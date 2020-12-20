package com.ddona.demorecycleview.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.databinding.FragmentListMusicOfflineBinding
import com.ddona.demorecycleview.model.MediaManagerOffline
import com.ddona.demorecycleview.model.MusicOffline
import com.ddona.demorecycleview.ui.adapter.MusicOfflineAdapter

class MusicOfflineFragment : Fragment(), MusicOfflineAdapter.IMusic {
    private lateinit var binding: FragmentListMusicOfflineBinding
    private val musicOffLines = mutableListOf<MusicOffline>()
    private val play = MediaManagerOffline()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListMusicOfflineBinding.inflate(
            inflater, container, false
        )
        getAllMusic()
        binding.rc.layoutManager = LinearLayoutManager(context)
        binding.rc.adapter = MusicOfflineAdapter(this)
        return binding.root
    }

    private fun getAllMusic() {
        musicOffLines.clear()
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val cursor = context!!.contentResolver
            .query(uri, null, null, null, null)
        cursor!!.moveToFirst()
        val albumIds = mutableListOf<Long>()
        while (!cursor.isAfterLast) {
            val path = cursor.getString(
                cursor.getColumnIndex("_data")
            )
            val name = cursor.getString(
                cursor.getColumnIndex(
                    MediaStore.Audio.Media.DISPLAY_NAME
                )
            )
            val duration = cursor.getLong(
                cursor.getColumnIndex(
                    MediaStore.Audio.Media.DURATION
                )
            )
            val albumId = cursor.getLong(
                cursor.getColumnIndex(
                    MediaStore.Audio.Media.ALBUM_ID
                )
            )

            musicOffLines.add(
                MusicOffline(
                    name, path,
                    duration=duration,
                    albumId = albumId,
                    uriAlbum = Uri.parse("content://media/external/audio/albumart/" + albumId)
                )
            )
            if (albumId > 0) {
                albumIds.add(albumId)
            }
            cursor.moveToNext()
        }
        cursor.close()

//        if (albumIds.size > 0){
//            val mapId = getAlbum(albumIds)
//            for (key in mapId.keys) {
//                for (musicOffLine in musicOffLines) {
//                    if (musicOffLine.albumId == key){
//                        musicOffLine.pathAlbum = mapId.get(key)
//                    }
//                }
//            }
//        }
    }

    private fun getAlbum(albumIds: MutableList<Long>): Map<Long, String> {
        var listId = "(" + albumIds[0]
        for (index in 1..albumIds.size - 1) {
            listId += ", " + albumIds[index]
        }
        listId += ")"

        val uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
        val cursor = context!!.contentResolver
            .query(
                uri, null,
                "_id IN " + listId, null, null
            )
        cursor?.moveToFirst()
        val mapId = HashMap<Long, String>()
        while (!cursor!!.isAfterLast) {
            val id = cursor.getLong(
                cursor.getColumnIndex("_id")
            )
            val path = cursor.getString(
                cursor.getColumnIndex("album_art")
            )
            mapId.put(id, path)
            cursor.moveToNext()
        }
        cursor.close()
        return mapId
    }

    override fun getCount() = musicOffLines.size

    override fun getData(position: Int): MusicOffline {
        return musicOffLines[position]
    }

    override fun onClick(position: Int) {
        play.release()
        play.setData(musicOffLines[position].path)
        play.play()
    }
}