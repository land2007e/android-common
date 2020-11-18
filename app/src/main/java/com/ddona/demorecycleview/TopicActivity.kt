package com.ddona.demorecycleview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.adapter.TopicAdapter
import com.ddona.demorecycleview.databinding.ActivityTopicBinding
import com.ddona.demorecycleview.model.ItemTopic
import com.ddona.demorecycleview.model.Store

class TopicActivity : AppCompatActivity(), TopicAdapter.ITopic {
    private val itemTopics = mutableListOf<ItemTopic>()
    private lateinit var binding: ActivityTopicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_topic
        )
        inits()
        val adapter = TopicAdapter(itemTopics)
        adapter.setInter(this)
        binding.rcToptic.adapter = adapter
        binding.rcToptic.layoutManager = LinearLayoutManager(this)
    }

    private fun inits() {
        var topic = ItemTopic(
            R.drawable.im_2, "Truyện cổ tích Thế Giới",
            mutableListOf()
        )
        itemTopics.add(topic)
        topic.stores.add(
            Store(
                "https://truyencotich.vn/wp-content/uploads/2015/09/c%C3%A1i-gi%C3%A1-c%E1%BB%A7a-s%E1%BB%B1-th%C3%B4ng-th%C3%A1i-320x213.jpg",
                "Cái giá của sự thông thái",
                "Rất lâu rồi, có một nhà vua muốn hiểu biết thật nhiều nhưng lại lười. Một ngày nọ nhà vua triệu tập tất cả những nhà thông thái của vương quốc lại và ra lệnh cho họ phải thu thập tất cả những hiểu biết và sự thông thái trên thế gian đặt vào một chỗ để ông ta có thể học chúng.\n" +
                        "\n" +
                        "Theo lệnh nhà vua, các nhà thông thái đều làm việc cật lực. Sau hơn một năm, họ dâng lên ngài một trăm cuốn sách chứa đựng mọi sự hiểu biết ở đời. Nhưng khi nhìn qua các chồng sách, nhà vua ngán ngẩm nói:\n" +
                        "\n" +
                        "– Không! Ta cần một cách dễ dàng hơn. Biết bao giờ ta mới đọc xong và nhớ được ngần này cuốn sách.\n" +
                        "\n" +
                        "Rồi nhà vua lệnh cho họ phải tóm lược hàng trăm cuốn sách đó vào một cuốn mà thôi. Một năm sau, các nhà thông thái quay lại với một cuốn sách duy nhất. Cuốn sách to và dày cả ngàn trang. Nhà vua nhìn thấy liền la lên:\n" +
                        "\n" +
                        "– Không! Cuốn sách này dày quá! Ta sẽ mất rất nhiều thời gian mới đọc hết được.\n" +
                        "\n" +
                        "Một lần nữa, các nhà thông thái bị buộc phải tóm lược thật súc tích cuốn sách ấy vào chỉ một trang giấy để nhà vua dễ dàng mang theo và nhớ được.\n" +
                        "\n" +
                        "Mọi người xôn xao và than trời: “Sao có thể làm được như vậy?”. Nhưng họ không có sự lựa chọn nào khác cả. Họ biết hoặc là mệnh lệnh phải được thi hành, hoặc là đầu họ sẽ rơi. Nhà thông thái lớn tuổi nhất họp tất cả mọi người lại để tìm ra cách giải quyết. Cuộc hội ý diễn ra trong nhiều đêm liền. Cuối cùng, họ đã hoàn thành trang giấy chứa đựng mọi sự hiểu biết trên đời.\n" +
                        "\n" +
                        "Được tin, nhà vua rất đỗi vui mừng. “Cuối cùng thì ta cũng sắp biết được tất cả mọi sự khôn ngoan nhất trên đời mà chỉ cần một trang giấy mà thôi!” – Nhà vua đắc chí nhủ thầm và ra lệnh dâng trang giấy lên trong thời gian sớm nhất.\n" +
                        "\n" +
                        "Và ngày đó đã tới. Nhà vua khấp khởi mừng thầm. Cả vương quốc đều tụ tập về quanh triều đình để được biết về điều đặc biệt đó. Nhà vua háo hức mở trang giấy chứa đựng toàn bộ sự thông thái của thế gian. Trong đó chỉ duy nhất một câu: “Không có sự thông thái nào mà không phải trả giá”."
            )
        )



        topic = ItemTopic(
            R.drawable.im_1, "Truyện cổ tích Việt Nam",
            mutableListOf()
        )
        itemTopics.add(topic)
        topic.stores.add(
            Store(
                "https://truyencotich.vn/wp-content/uploads/2015/05/ba-l%C6%B0%E1%BB%A1i-r%C3%ACu.jpg",
                "Ba lưỡi rìu",
                "Xưa có một anh chàng tiều phu nghèo, cha mẹ anh bệnh nặng nên qua đời sớm, anh phải sống mồ côi cha mẹ từ nhỏ và tài sản của anh chỉ có một chiếc rìu. Hàng ngày anh phải xách rìu vào rừng để đốn củi bán để lấy tiền kiếm sống qua ngày. Cạnh bìa rừng có một con sông nước chảy rất xiết, ai đó lỡ trượt chân rơi xuống sông thì rất khó bơi vào bờ.\n" +
                        "\n" +
                        "Một hôm, như thường ngày chàng tiều phu vác rìu vào rừng để đốn củi, trong lúc đang chặt củi cạnh bờ sông thì chẳng may chiếc rìu của chàng bị gãy cán và lưỡi rìu văng xuống sông. Vì dòng sông nước chảy quá xiết nên mặc dù biết bơi nhưng anh chàng vẫn không thể xuống sông để tìm lưỡi rìu. Thất vọng anh chàng tiều phu ngồi khóc than thở.\n" +
                        "\n" +
                        "Bỗng từ đâu đó có một ông cụ tóc trắng bạc phơ, râu dài, đôi mắt rất hiền từ xuất hiện trước mặt chàng, ông cụ nhìn chàng tiêu phu và hỏi:\n" +
                        "\n" +
                        "-Này con, con đang có chuyện gì mà ta thấy con khóc và buồn bã như vậy?\n" +
                        "\n" +
                        "Anh chàng tiều phu trả lời ông cụ:\n" +
                        "\n" +
                        "-Thưa cụ, bố mẹ cháu mất sớm, cháu phải sống mồ côi từ nhỏ, gia cảnh nhà cháu rất nghèo, tài sản duy nhất của cháu là chiếc rìu sắt mà bố mẹ cháu trước lúc qua đời để lại. Có chiếc rìu đó cháu còn vào rừng đốn củi kiếm sống qua ngày, giờ đây nó đã bị rơi xuống sông, cháu không biết lấy gì để kiếm sống qua ngày nữa. Vì vậy cháu buồn lắm cụ ạ!\n" +
                        "\n" +
                        "Ông cụ đáp lời chàng tiều phu:\n" +
                        "\n" +
                        "-Ta tưởng chuyện gì lớn, cháu đừng khóc nữa, để ta lặn xuống sông lấy hộ cháu chiếc rìu lên.\n" +
                        "\n" +
                        "Dứt lời, ông cụ lao mình xuống dòng sông đang chảy rất xiết. Một lúc sau, ông cụ ngoi lên khỏi mặt nước tay cầm một chiếc rìu bằng bạc sáng loáng và hỏi anh chàng tiều phu nghèo:\n" +
                        "\n" +
                        "– Đây có phải lưỡi rìu mà con đã làm rơi xuống không ?\n" +
                        "\n" +
                        "Anh chàng tiều phu nhìn lưỡi rìu bằng bạc thấy không phải của mình nên anh lắc đầu và bảo ông cụ:\n" +
                        "\n" +
                        "– Không phải lưỡi rìu của cháu cụ ạ, lưỡi rìu của cháu bằng sắt cơ.\n" +
                        "\n" +
                        "Lần thứ hai, ông cụ lại lao mình xuống dòng sông chảy xiết để tìm chiếc rìu cho chàng tiều phu. Một lúc sau, ông cụ ngoi lên khỏi mặt nước tay cầm chiếc rìu bằng vàng và hỏi chàng tiều phu:\n" +
                        "\n" +
                        "-Đây có phải là lưỡi rìu mà con đã sơ ý làm rơi xuống sông không?\n" +
                        "\n" +
                        "Anh chàng tiều phu nhìn lưỡi rìu bằng vàng sáng chói, anh lại lắc đầu và bảo:\n" +
                        "\n" +
                        "-Không phải là lưỡi rìu của con cụ ạ\n" +
                        "\n" +
                        "Lần thứ ba, ông cụ lại lao mình xuống sông và lần này khi lên ông cụ cầm trên tay là chiếc rìu bằng sắt của anh chàng tiều phu đánh rơi. Ông cụ lại hỏi:\n" +
                        "\n" +
                        "-Vậy đây có phải là lưỡi rìu của con không!\n" +
                        "\n" +
                        "Thấy đúng là lưỡi rìu của mình rồi, anh chàng tiều phu reo lên sung sướng:\n" +
                        "\n" +
                        "-Vâng cụ, đây đúng là lưỡi rìu của con, con cảm ơn cụ đã tìm hộ con lưỡi rìu để con có cái đốn củi kiếm sống qua ngày.\n" +
                        "\n" +
                        "Ông cụ đưa cho anh chàng tiều phu lưỡi rìu bằng sắt của anh và khen:\n" +
                        "\n" +
                        "-Con quả là người thật thà và trung thực, không hề ham tiền bạc và lợi lộc. Nay ta tặng thêm cho con hai lưỡi rìu bằng vàng và bạc này. Đây là quà ta tặng con, con cứ vui vẻ nhận.\n" +
                        "\n" +
                        "Anh chàng tiều phu vui vẻ đỡ lấy hai lưỡi rìu mà ông cụ tặng và cảm tạ. Ông cụ hóa phép và biến mất. Lúc đó anh chàng tiều phu mới biết rằng mình vừa được bụt giúp đỡ.\n" +
                        "\n" +
                        "Nguồn: Truyện cổ tích tổng hợp."
            )
        )


        topic.stores.add(
            Store(
                "https://truyencotich.vn/wp-content/uploads/2012/10/nguoi-tot-660x440.jpg",
                "Cô đào hát với người học trò nghèo",
                "Ngày xưa, có một đứa bé thông minh tên là Nguyễn Kỳ, mẹ mất sớm, cha lấy vợ khác. Kỳ bị dì ghẻ hành hạ ác nghiệt nên phải bỏ nhà mà đi.\n" +
                        "\n" +
                        "Lang thang khắp nơi, Kỳ gặp một cụ cử cho ở lại nhà và cho học chữ. Sẵn khiếu thông minh, Kỳ không những theo kịp các bạn, mà còn nổi tiếng giỏi văn thơ.\n" +
                        "\n" +
                        "Một hôm Kỳ theo bạn học đi xem ca múa, thấy mình nghèo nên đứng trong góc nhà, chợt cô đào hát trông thấy, và hôm sau, khi Kỳ đang ngồi đọc sách thì cô đào đem 10 nén bạc đến làm quen. Kỳ nhất định không lấy, nhưng cô ta nài ép, để bạc đấy rồi bỏ đi. Cách ít lâu, nàng trở lại, rồi trở lại nữa. Hai bên dần dần quen nhau. Một hôm, không còn tự chủ được trước người con gái đẹp, giọng thướt tha, Kỳ làm một cử chỉ suồng sã, rồi hối hận ngay. Nhưng cô đào nghiêm nghị trách:\n" +
                        "\n" +
                        "“Anh chớ vội tưởng lầm, em tìm đến anh vì trọng người đứng đắn, vì nghĩ đến tương lai, muốn tìm nơi nương tựa lâu dài, anh đừng nghĩ em là phường bậy bạ.”\n" +
                        "\n" +
                        "Từ đó Kỳ càng trọng kính cô đào hơn, và cô vẫn giúp Kỳ qua cơn túng thiếu.\n" +
                        "\n" +
                        "Trước ngày lên đường đi thi, Kỳ muốn biết tông tích cô đào, muốn liên lạc với cô sau này, nhưng cô chỉ nói:\n" +
                        "\n" +
                        "“Sau này nếu anh không quên em, thì em sẽ tìm đến với anh, nếu anh quên em, thì hỏi tông tích em cũng vô ích. Phần em, em không đòi anh hứa gì cả, chỉ có Trời biết lòng em.”\n" +
                        "\n" +
                        "Khi Kỳ thi đỗ trở về quê, cha chàng bắt kết hôn với người “môn đăng hộ đối”. Kỳ hết sức từ chối, nhất quyết thà chết hơn phụ bạc người đã một lần yêu thương giúp đỡ, nhưng cha chàng cũng nhất quyết không chịu cho quan chức kết duyên với cô ả đào, không nhận ả đào làm con dâu. Nguyễn Kỳ đau khổ, nhưng lễ giáo bắt buộc, bổn phận làm con bắt buộc, nên chàng đành phải lấy vợ theo ý cha.\n" +
                        "\n" +
                        "Năm sau, chàng ra kinh đô thi tiến sĩ, cô đào mang đủ thứ đến thăm. Thấy Kỳ có vẻ ngượng ngùng, cô hiểu ngay, và từ biệt hẳn.\n" +
                        "\n" +
                        "Nguyễn Kỳ thi đỗ, làm quan trong triều, đi sứ bên Tàu, dẹp loạn ở Hải dương, được vua ban thưởng tước “quận công”.\n" +
                        "\n" +
                        "Danh vọng cao, tiền bạc sẵn, con cái đông, nhưng Kỳ luôn nhớ tới tình cô đào hát xưa, cho người dọ hỏi khắp nơi, nhưng không gặp.\n" +
                        "\n" +
                        "Một hôm, trong bữa tiệc tại nhà người quan bạn, Kỳ đã tình cờ gặp lại cô đào, bấy giờ nàng đã có chồng làm lính, nhưng nay chồng đã chết, chỉ còn có mẹ già yếu bệnh, nàng phải trở lại nghiệp hát để nuôi mình và nuôi mẹ.\n" +
                        "\n" +
                        "Nguyễn Kỳ cố mời hai mẹ con về ở trong dinh, nàng đành chấp nhận. Kỳ dành cho mẹ con ngôi nhà riêng, và không để cho thiếu thốn vật gì. Một năm sau bà cụ mất, Nguyễn Kỳ cho chôn cất trọng thể. Xong rồi nàng cảm ơn và xin phép từ biệt. Nguyễn kỳ không giữ lại được, nài nỉ nàng nhận lấy vài nén bạc, nàng cũng từ chối mà ra đi."
            )
        )
        topic.stores.add(
            Store(
                "https://truyencotich.vn/wp-content/uploads/2012/10/cay-tre-tram-dot-660x440.jpg",
                "Cây tre trăm đốt",
                "Ngày xưa, có một ông già nhà quê có một cô gái đẹp. Trong nhà phải thuê một đầy tớ trai, ông ta muốn lợi dụng nó làm việc khỏi trả tiền, mới bảo nó rằng: “Mày chịu khó làm ăn với tao rồi tao gả con gái cho”. Người ở mừng lắm, ra sức làm lụng tới khuya không nề hà mệt nhọc. Nó giúp việc được ba năm, nhà ông ta mỗi ngày một giàu có.\n" +
                        "\n" +
                        "Ông nhà giàu không còn nghĩ đến lời hứa cũ nữa, đem con gái gả cho con một nhà phú hộ khác ở trong làng.\n" +
                        "\n" +
                        "Sáng hôm sắp đưa dâu, ông chủ gọi đứa ở lên lừa nó một lần nữa, bảo rằng: “Bây giờ mày lên rừng tìm cho ra một cây tre có trăm đốt đem về đây làm đũa ăn cưới, thì tao cho mày lấy con gái tao ngay”.\n" +
                        "\n" +
                        "Đứa ở tưởng thật, vác dao đi rừng. Nó kiếm khắp nơi, hết rừng này qua rừng nọ, không tìm đâu thấy có cây tre đủ trăm đốt. Buồn khổ quá, nó ngồi một chỗ ôm mặt khóc. Bỗng thấy có một ông lão râu tóc bạc phơ, tay cầm gậy trúc hiện ra bảo nó: “Tại sao con khóc, hãy nói ta nghe, ta sẽ giúp cho”. Nó bèn đem đầu đuôi câu chuyện ông phú hộ hứa gả con gái cho mà kể lại. Ông lão nghe xong, mới bảo rằng: “Con đi chặt đếm đủ trăm cái đốt tre rồi đem lại đây ta bảo”.\n" +
                        "\n" +
                        "Nó làm theo y lời dặn, ông dạy nó đọc: “Khắc nhập, khắc nhập” (vào ngay, vào ngay) đủ ba lần, thì một trăm khúc tre tự nhiên dính lại với nhau thành một cây trẻ đủ một trăm đốt. Nó mừng quá, định vác về, nhưng cây tre dài quá, vướng không đi được. Ông lão bảo nó đọc: “Khắc xuất, khắc xuất” (ra ngay, ra ngay) đúng ba lần thì cây tre trăm đốt lại rời ra ngay từng khúc.\n" +
                        "\n" +
                        "Nó bèn bó cả lại mà gánh về nhà. Đến nơi thấy hai họ đang ăn uống vui vẻ, sắp đến lúc rước dâu, nó mới hay là ông chủ đã lừa nó đem gả con gái cho người ta rồi. Nó không nói gì, đợi lúc nhà trai đốt pháo cưới, bèn đem một trăm khúc tre xếp dài dưới đất, rồi lẩm bẩm đọc: “Khắc nhập, khắc nhập” cho liền lại thành một cây tre trăm đốt, đoạn gọi ông chủ đến bảo là đã tìm ra được, và đòi gả con gái cho nó. Ông chủ lấy làm lạ cầm cây tre lên xem, nó đọc luôn: “Khắc nhập, khắc nhập”, thì ông ta bị dính liền ngay vào cây tre, không làm sao gỡ ra được. Ông thông gia thấy vậy chạy đến, định gỡ cho, nó lại đọc luôn: “Khắc nhập, khắc nhập”, thì cả ông cũng bị dính theo luôn, không lôi ra được nữa.\n" +
                        "\n" +
                        "Hai họ thấy thế không còn ai dám lại gần nó nữa. Còn hai ông kia không còn biết làm thế nào đành van lạy xin nó thả ra cho. Ông chủ hứa gả con gái cho nó, ông thông gia xin về nhà ngay, nó để cho cả hai thề một hồi rồi nó mới đọc: “Khắc xuất, khắc xuất” thì hai ông rời ngay cây tre, và cây tre cũng rời ra trăm khúc.\n" +
                        "\n" +
                        "Mọi người đều lấy làm khiếp phục đứa ở, ông chủ vội gả con gái cho nó, và từ đó không còn dám khinh thường nó nữa."
            )
        )
        topic.stores.add(
            Store(
                "https://truyencotich.vn/wp-content/uploads/2015/09/nguy%E1%BB%85n-khoa-%C4%91%C4%83ng-640x440.jpg",
                "Nguyễn Khoa Đăng",
                "Ngày xưa, có nội tán Nguyễn Khoa Đăng là người có tài xử đoán. Khi còn làm một chức quan nhỏ, ông đến trị nhậm hạt nào thường được mọi người mến phục, không chỉ vì tài xét xử mà còn vì lòng tốt của ông lúc nào cũng lo trừ hại cho dân.\n" +
                        "Có lần, ông đến nhậm chức ở một huyện, một hôm có người dân làng kia bị kẻ thù oán, đêm đến lẻn ra đồng phá hết cả một ruộng dưa. Đau xót cho công lao vun trồng, dưa sắp được ăn chỉ trong một đêm bị héo rụng hết cả, người ấy bèn đến kêu khóc với ông, xin ông minh xét. Ông Đăng theo ngay người ấy về tận ruộng dưa khám nghiệm. Tất cả dấu vết đều chứng tỏ kẻ gian đã dùng một cái thuổng xắn đứt ngọn dưa và dùng cán giẫm nát hầu hết các gốc dưa. Nhưng hắn rất khôn ngoan, bao nhiêu dấu chân, hắn đều cố ý xóa sạch. Ông hỏi người trồng dưa:\n" +
                        "\n" +
                        "– Anh có ngờ ai thù oán mình không?\n" +
                        "\n" +
                        "Người ấy kể cho quan nghe tên mấy người ở xóm, lập tức ông sai chức dịch đi thu hồi tất cả các thuổng trong xóm lại, thuổng của nhà nào đều có ghi tên nhà ấy vào cán. Đoạn, ông khám từng cán thuổng một, nhặt riêng mấy cái khả nghi ra một nơi. Rồi ông sai người thè lưỡi liếm trên mấy cái cán thuổng đó. Quả nhiên có một cái, người ta nhận thấy có vị đắng. Ông sai lấy một gốc dưa đập giập vắt nước ra nếm thử thì chất đắng của dưa cùng với chất đắng trên cán thuổng là một. Ông nhìn lại tên ghi ở thuổng thì đúng là thuổng của một trong số mấy người mà nguyên cáo ngờ là có thù oán với mình.\n" +
                        "\n" +
                        "Lập tức ông sai lính bắt người kia giải đến. trước tang chứng và lý lẽ đanh thép của quan, hắn không còn chối vào đâu được, đành cúi đầu nhận tội. Ông bắt hắn phải đền hoa lợi ruộng dưa cho người kia và phạt thêm gấp hai lần để hắn chừa cái thói hại ngầm kẻ khác.\n" +
                        "\n" +
                        "Một hôm khác, có một anh hàng dầu, gánh một gánh ra chợ bán. Trong khi đang bận đong dầu, có kẻ đã thừa dịp thò tay vào bị lấy trộm tiền. Đến khi anh hàng dầu biết thì tên ăn cắp đã chạy đi nơi khác. Anh ta nhớ tới một người mù hồi nãy quanh quẩn bên gánh của mình, đuổi mấy cũng không đi, đoán chắc là kẻ cắp, bèn gửi gánh hàng cho người quen rồi đi tìm người mù lúc nãy. Nhưng khi gặp, người mù hết sức chối cãi, rằng mình mù thì còn biết tiền của để ở đâu mà lấy. Hai bên xô xát, tuần bắt giải quan.\n" +
                        "\n" +
                        "Khi họ dắt nhau đến công đường, ông Đăng bắt hai bên khai rõ sự tình. Người mù khăng khăng từ chối không nhận. Ông Đăng hỏi:\n" +
                        "\n" +
                        "– Anh có tiền giắt đi theo đấy không?\n" +
                        "\n" +
                        "Trả lời:\n" +
                        "\n" +
                        "– Có, nhưng đây là tiền tôi mang đi chợ, không phải của nó.\n" +
                        "\n" +
                        "– Được cứ đưa ra đây, của ai rồi sẽ biết.\n" +
                        "\n" +
                        "Khi người mù móc tiền ra, ông Đăng sai người múc đến một chậu nước, rồi bỏ tất cả số tiền vào chậu. Một chốc tự nhiên thấy trên mặt nước có váng dầu nổi lên. Nghe quan sai bưng chậu nước cho mọi người chứng kiến, người mù hết đường chối, đành chịu tội ngay.\n" +
                        "\n" +
                        "Nhưng quan còn nói thêm:\n" +
                        "\n" +
                        "– Khoan đã, chưa hết đâu. Tội ăn cắp mới là một. Nếu mày mù tịt thì làm sao biết được tiền người hàng dầu bỏ trong bị, cất trong thúng khảo mà lấy được! Đúng là mày giả mù. Lính đâu. Bắt nó nọc ra đánh cho rõ đau, kỳ bao giờ nó mở hai mắt ra hãy thôi.\n" +
                        "\n" +
                        "Người mù trước còn chối lấy chối để, nhưng chỉ qua ba roi là hắn mở ngay hai mắt nhận tội, đúng như lời quan truyền bảo[1].\n" +
                        "\n" +
                        "Một hôm khác, có một người lái buôn giấy đến trình quan rằng mình nghỉ trọ ở làng Hồ-xá bị trộm lấy mất cả một gánh giấy. Ông Đăng hỏi rõ nguồn cơn, sai người do thám mấy ngày liền không có kết quả, bèn thân hành đến làng Hồ-xá nghĩ cách cứu xét. Đến nơi, ông cho triệu dân chúng sở tại và mấy làng xung quanh lại và bảo:\n" +
                        "\n" +
                        "– Trên tỉnh vừa sức về bắt các xã thôn mỗi một người không kể nam phụ lão ấu phải làm ngay một tờ khai tên tuổi quê quán cho minh bạch.\n" +
                        "\n" +
                        "Lệnh ban ra, mọi người đua nhau đi mua giấy. Vì thế giấy ở chợ lên giá vùn vụt.\n" +
                        "\n" +
                        "Lại nói chuyện tên trộm trộm được gánh giấy nhưng chưa có nơi tiêu thụ còn giấu ở nhà. Nay nghe nói giá giấy lên cao bèn mang lẻn một số ra chợ bán. Hắn không ngờ người nhà của ông Đăng cũng đi rải ở các chợ để chờ hắn. Thế là bị bại lộ, tên trộm không những bị tội phải đền gánh giấy cho người lái buôn mà còn phải đền cho dân các làng mặt tiền mua giấy kê khai tên tuổi.\n" +
                        "\n" +
                        "Một lần khác, ông được đổi đi một hạt miền núi. Khi ông mới đến, người ta cho ông biết là hạt ấy nổi tiếng có nhiều trộm cướp nhà nghề. Các quan trước bó tay không thể nào trị nổi. Ông chỉ cười nhạt không nói gì, nhưng sau đó ngầm sai người thân tín đi dò la hành tung và quê quán từng tên một. Thế rồi, ông vẫn cứ tảng lờ như là không hay biết gì hết.\n" +
                        "\n" +
                        "Một hôm nhân đi hành hạt qua một làng nọ, ông thấy có một hòn đá lớn ở bên vệ đường. Hỏi dân sở tại, họ đáp:\n" +
                        "\n" +
                        "– Đây là ông Mốc, ngài thiêng lắm, ai cầu khẩn việc gì cũng đều được linh ứng.\n" +
                        "\n" +
                        "Ông nghe nói liền họa theo:\n" +
                        "\n" +
                        "– Phải thế thì ta tới cầu ngài giúp ta trừ yên cướp trộm để bớt hại cho dân chúng mới được!\n" +
                        "\n" +
                        "Nói rồi một mình bước tới khấn vái, hồi lại trở ra bảo mọi người rằng:\n" +
                        "\n" +
                        "– Ngài bảo vài hôm nữa rước ngài về, ngài sẽ vạch mặt tất cả bọ gian phi trong toàn huyện.\n" +
                        "\n" +
                        "Ít hôm sau, ông sai mấy người ban đêm bí mật đào hầm ở giữa sân công đường rồi cho người thân tín xuống nấp dưới đó. Tờ mờ sáng hôm sau, ông sai lính đi khiêng hòn đá về đặt lên trên hầm. Trước mặt mọi người đông đủ, ông dõng dạc hỏi đá:\n" +
                        "\n" +
                        "– Ta nghe đồn thần rất thiêng, “hữu cầu tất ứng”. Nay ta vâng mệnh hoàng đế đến đây trấn nhậm, nhưng hiện nay trong huyện hạt có nhiều trộm cướp nhiễu hại dân cư. Vậy ta mời thần về đây để mách hộ ta truy tầm kẻ phạm pháp. Nếu có công, ta sẽ tâu triều đình phong tặng.\n" +
                        "\n" +
                        "Đá không trả lời. Hỏi mãi, đá vẫn một mực làm thinh, ông nổi giận quát lớn:\n" +
                        "\n" +
                        "– Hay là đá đồng lõa với kẻ phạm pháp. Lính đâu, hãy tra tấn nó cho đến lúc nó phải khai thực!\n" +
                        "\n" +
                        "Bấy giờ, mọi người nghe tin đến xem đông như hội. Lệnh truyền xa, lính dùng roi đánh vào đá túi bụi, tự nhiên đá bật ra tiếng khóc, xin dừng tay lại để khai. Thế rồi, đá lần lượt khai và vạch tội từng tên một. Mỗi lần đá khai một tên nào, ông sai lại mục viết ngay trát, giao cho lính đã chực sẵn đi nã bắt lập tức. Cho đến suốt ngày hôm đó bắt được ba mươi tên cừ khôi. Khi giải cả một xốc về tra tấn, bọn trộm cướp nhìn nhau kinh ngạc, không ngờ lại có việc xảy ra như thế và bắt đúng tên như thế. Chúng cho là chỉ có thần đá linh thiêng mới biết một cách rành mạch tội trạng của mình, bèn không đợi khảo đả, thú nhận tất cả.\n" +
                        "\n" +
                        "Trong thời kỳ làm nội tán, ông đã làm cho suốt một dọc truông nhà Hồ ở Quảng Trị không còn lấy một bóng gian phi. Trước đó, truông này là nơi rừng rậm, con đường Nam Bắc phải đi qua đây. Bọn gian phi đã dùng làm sào huyệt đón đường cướp của.\n" +
                        "\n" +
                        "Nguyễn Khoa Đăng trước hết tìm cách lùng bắt trộm cướp. Ông sai chế ra một loại hòm gỗ kín có những lỗ thông khí, vừa một người ngồi lọt, có khóa trong, để người ngồi trong có thể mở tung ra được dễ dàng. Thế rồi, ông kén một số người giỏi võ, cho ngồi vào hòm có để sẵn vũ khí. Đoạn, ông sai quan sĩ của mình giả trang làm dân phu khiêng những hòm ấy qua truông nhà Hồ ra vẻ khiêng những hòm “của cải” nặng nề. Lại cho người đánh tiếng có một ông quan trấn ở ngoài Bắc sắp sửa trẩy về quê với những hòm tư trang quý giá sẽ đi qua truông. Bọn cướp đánh hơi thấy đây là một cơ hội kiếm ăn hiếm có, bèn rình lúc đoàn “dân phu” đi qua của truông, xông ra đánh đuổi, rồi hý hửng khiêng những cái hòm nặng ấy về tận sào huyệt.\n" +
                        "\n" +
                        "Nhưng khi về đến nơi thì vừa đặt xuống thì những cái hòm tự nhiên mở toang, các võ sĩ ngồi trong đó cầm vũ khí xông ra đánh giết bọn cướp một cách bất ngờ. Đang lúc hoảng hốt chưa kịp đối phó thì bọn chúng nghe tin phục binh của triều đình ở phía ngoài ùn ùn kéo vào đông như kiến cỏ. Chúng đành chắp tay xin tha tội. Nhờ mẹo đó, Nguyễn Khoa Đăng đã tóm được cả lũ.\n" +
                        "\n" +
                        "Ông cho phiên chế thành đội ngũ đi khai khẩn đất hoang ở nơi biên giới, lập thành những đồn điền lớn rộng. Sau đó, ông còn cho chiêu dân lập ấp ở dọc hai bên truông, làm cho một vùng trước kia là nơi vắng vẻ, trở nên những làng xóm dân cư đông đúc: tiếng xay lúa giã gạo, tiếng gà gáy chó sủa lấn dần tiếng vượn hú chim kêu. Từ đó, một vùng núi rừng thành ra yên ổn. Bọn trộm cướp còn lại đành phải giải nghệ.\n" +
                        "\n" +
                        "Bởi vậy, người ta có câu: “Truông nhà Hồ nội tán cấm nghiêm” là thế."
            )
        )
    }

    override fun clickItem(position: Int) {
        val intent = Intent()
        intent.setClass(this, StoreListActivity::class.java)
        intent.putExtra(
            "DATA",
            itemTopics[position]
        )
        startActivity(intent)
    }
}