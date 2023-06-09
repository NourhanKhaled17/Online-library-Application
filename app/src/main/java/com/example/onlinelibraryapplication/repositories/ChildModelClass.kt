package com.example.onlinelibraryapplication.repositories

import com.example.onlinelibraryapplication.R

data class ChildModelClass(
    var image: Int,
    var name: String,
    var job: String,
    var description: String,
    var hisBooks: String,
    var backgroundColor: Int
)

val b1 = ChildModelClass(
    R.drawable.ahmedkaled,
    "أحمد خالد توفيق",
    "كاتب وروائي",
    "المؤلف كتاب حكايات الغرفة 207 والمؤلف لـ 780 كتب أخرى.\n" +
            "أحمد خالد توفيق فراج (10 من يونيو 1962م - 15 من رجب 1439 هـ/ 2 من إبريل 2018م)، مؤلف وروائي وطبيب مصري. يعد أول كاتب عربي في مجال أدب الرعب والأشهر في مجال أدب الشباب والفانتازيا والخيال العلمي ولقب بالعراب.\n" +
            "\n" +
            "بدأت رحلته الأدبية مع كتابة سلسلة ما وراء الطبيعة، ورغم أن أدب الرعب لم يكن سائدًا في ذلك الوقت فإن السلسلة حققت نجاحًا كبيرًا واستقبالًا جيدًا من الجمهور، ما شجعه على استكمالها، وأصدر بعدها سلسلة فانتازيا عام 1995 وسلسلة سفاري عام 1996. في عام 2006 أصدر سلسلة WWW.",
    "- سلسلة ما وراء الطبيعة\n" +
            "- يوتيوبيا\n" +
            "- في مرر الفئران\n" +
            "- رجل الرمال\n" +
            "- الغرفة 207\n" +
            "- عقل بلا جسد\n" +
            "- سلسلة سافاري\n",
    R.drawable.author_background
)
val b2 = ChildModelClass(
    R.drawable.taha,
    "طه حسين",
    "كاتب",
    "طه حسين علي بن سلامة (1306 هـ / 15 نوفمبر 1889 - 1393 هـ / 28 أكتوبر 1973م)، وشهرته «طه حسين»، أديب وناقد مصري، لُقّب بعميد الأدب العربي. يعتبر من أبرز الشخصيات في الحركة العربية الأدبية الحديثة. لا تزال أفكار ومواقف طه حسين تثير الجدل حتى اليوم.",
    "كتبه الفكرية: \n" +
            "على هامش السيرة ،الشيخان، الفتنة الكبرى عثمان،  الفتنة الكبرى علي وبنوه ، مستقبل الثقافة في مصر ، مرآة الإسلام ، فلسفة ابن خلدون الإجتماعية ، من آثار مصطفى عبد الرزاق ، حديث المساء ، غرابيل.\n" +
            "كتبه النقدية: في الشعر الجاهلي.\n" +
            "في الأدب الجاهلي ، الحياة الأدبية في جزيرة العرب ، فصول في الأدب والنقد ،  حديث الأربعاء ، حافظ وشوقي ، صوت أبي العلاء ،مع أبي العلاء في سجنه ، تجديد ذكرى أبي العلاء ، مع المتنبي ،من حديث الشعر والنثر ،من أدبنا المعاصر ، ألوان ،خصام ونقد ، من لغو الصيف\n" +
            "من الشاطيء الآخر (كتابات طه حسين بالفرنسية) ، أدبنا الحديث ما له وما عليه،\n" +
            "صحف مختارة من الشعر التمثيلي عند اليونان ، الحياة والحركة الفكرية في بريطانيا ،قادة الفكر.\n" +
            "كتبه الإثرائية:\n" +
            "المعذبون في الأرض ، الأيام ،أحلام شهرزاد ،أديب ، رحلة الربيع ،أيام العمر (رسائل)…",
    R.drawable.author_background
)
val b3 = ChildModelClass(
    R.drawable.hanan,
    "حنان لاشين",
    "كاتبة",
    "حنان لاشين هي كاتبة روائية مصرية حاصلة على بكالوريوس الطب البيطري من جامعة الإسكندرية، وهي عضو اتحاد كتاب مصر، نُشرت لها عدة مقالات في موقع «طريق الإسلام» وموقع «صيد الفوائد» وعلى شبكة الألوكة ومجلة «ممكن» الشبابية وكذلك مجلة «ببساطة» الإلكترونية.\n" +
            "قامت بكتابة قصة وسيناريو المسلسل الإذاعي «أنس في بلاد العجائب» الذي سُجِّل على موقع عمرو خالد بطولة الفنان وجدي العربي والفنان عمرو القاضي، وقامت أيضا بكتابة «مسافر زاده القرآن» و«مذكرات صائم» وهي حلقات مسلسلة يومية سُجِّلت وعُرضَت على نفس الموقع في رمضان. كما حازت على المركز الأول في مسابقة قصص الخيال العلمي بموقع عمرو خالد عام 2005، حيث شاركت برواية «السرداب» عن العالم العربي «ثابت بن قرّة».",
    "كوني صحابية (مجموعة مقالات دعوية باللغة العربية)\n" +
            "ممنوع الضحك (كتاب ساخر بالعامية المصرية).\n" +
            "منارات الحب (مقالات توعويّة للمقبلين على الزّواج وعن كيفيّة اختيار شريك الحياة)\n" +
            "قطار الجنة (مجموعة قصصية للأطفال)\n" +
            "غزل البنات (رواية)\n" +
            "الهالة المقدسة (رواية)\n" +
            "خماسية «مملكة البلاغة» (سلسلة روايات)",
    R.drawable.author_background
)
val b4 = ChildModelClass(
    R.drawable.agatha,
    "اجاثا كريستي",
    "كاتبة",
    "تُعتبر أجاثا كريستي أعظم مؤلفة في التاريخ من حيث انتشار كتبها وعدد ما بيع منها من نسخ، وهي -بلا جدال- أشهر مَن كتب قصص الجريمة في القرن العشرين وفي سائر العصور. وقد تُرجمت رواياتها إلى معظم اللغات الحية، وقارب ما طُبع منها بليونَيْ (ألفَيْ مليون)نسخة!\n" +
            "وُلدت أجاثا كريستي في بلدة توركي بجنوب إنكلترا عام 1890 وتوفيت عام 1976 وعمرها نحو خمسة و ثمانين عاماً.\n" +
            "لم تذهب أجاثا قطّ إلى المدرسة، بل تلقّت تعليمها في البيت على يد أمها التي دفعتها إلى الكتابة وشجعتها عليها في وقت مبكر من حياتها",
    "قضية ستايلز الغامضة \n" +
            "، العدو الغامض (رواية) \n" +
            "، جريمة في ملعب الغولف ،\n" +
            " ذو البدلة البنية ، لغز القطار الأزرق ،\n" +
            " خبز العملاق ، لغز سيتافورد ،\n" +
            " الأدميرال العائمة ،\n" +
            " جريمة في قطار الشرق السريع\n" +
            " ، صورة غير مكتملة ،\n" +
            " جرائم الأبجدية ،\n" +
            " أوراق لعب على الطاولة ،\n" +
            " موعد مع الموت ،\n" +
            " الشاهد الصامت ،\n" +
            " القتل السهل ، \n" +
            "جثة في المكتبة ، في النهاية يأتي الموت .. \n" +
            "مجموعات القصص القصيرة ومنها \n" +
            "شركاء في الجريمة ، السيد كوين الغامض ،\n" +
            " كلب الموت ، جريمة قتل في الإسطبلات \n" +
            "، تحريات باركر بين ، بويروت في العطلة ،\t\n" +
            "،السيدة المحجبة وغموض في بغداد . \n" +
            "الأعمال الإذاعية ومنها خلف الشاشة ، النبأ المُثير ، عش الدبابير ، السوسن الأصفر . \n" +
            "الأعمال المسرحية ومنها القهوة السوداء ، ثم لم يبق منهم أحد ، موعد مع الموت ، جريمة على النيل ، مصيدة الفئران ، بيت العنكبوت",
    R.drawable.author_background
)
val b5 = ChildModelClass(
    R.drawable.amr,
    "عمرو عبد الحميد",
    "كاتب",
    "عمرو عبد الحميد (مواليد محافظة الدقهلية في 1987م)، هو كاتب روائي مصري. درس الطب متخصصاً بجراحة الأنف والأذن والحنجرة بجامعة المنصورة. اشتهر كاتبًا في مجال الخيال بأول أعماله المنشورة وهي ثنائية أرض زيكولا وأماريتا، وصدر له مؤخراً دقات الشامو الجزء الثاني من رواية قواعد جارتين وجزئها الثالث أمواج أكما.",
    "بدأ كتابة الرواية مع محاولتين روائيتين قصيرتين عام 2008 هما حسناء القطار وكاسانو.\n" +
            "أرض زيكولا (2010).\n" +
            "أماريتا (2016).\n" +
            "قواعد چارتين صدرت في يناير 2018.\n" +
            "رواية دقات الشامو الجزء الثاني من قواعد چارتين في يناير 2019.\n" +
            "أمواج أكما.\n" +
            "فتاة الياقة الزرقاء.",
    R.drawable.author_background
)
val b6 = ChildModelClass(
    R.drawable.yoisef,
    "يوسف السباعي",
    "كاتب",
    "يوسف محمد محمد عبد الوهاب السباعي ( القاهرة، 17 يونيه 1917 - قبرص، 18 فبراير 1978)، وزير ثقافة مصر و اديب و مفكر و مؤلف روايات مصرى كبير، مع انه كان اديب و مش سياسى ، قتلوه ارهابيين فلسطينيين فى قبرص و هو بيحضر مؤتمر منظمة التضامن الأفرو-اسيوي اللى كان أمينها العام لإنه أيد السلام و وقف الحرب و نزيف الدم بين بلده مصر و اسرائيل.",
    "نائب عزرائيل - رواية 1947.\n" +
            "يا امة ضحكت - قصص - 1948.\n" +
            "ارض النفاق - رواية 1949.\n" +
            "إني راحلة - رواية 1950.\n" +
            "ام رتيبة - مسرحية 1951.\n" +
            "السقامات - رواية 1952.\n" +
            "بين ابو الريش وجنينة ناميش - قصص- 1950.\n" +
            "الشيخ زعرب وآخرون - قصص 1952.\n" +
            "فديتك يا ليل - رواية 1953.\n" +
            "البحث عن جسد - 1953.\n" +
            "بين الأطلال - رواية.\n" +
            "رد قلبى - رواية 1954.\n" +
            "طريق العودة - رواية 1956.\n" +
            "نادية - رواية 1960.\n" +
            "جفت الدموع - رواية 1962.\n" +
            "ليل له اخر - رواية 1963.\n" +
            "أقوى من الزمن - مسرحية 1965.\n" +
            "نحن لا نزرع الشوك - رواية 1969.\n" +
            "لست وحدك - رواية 1970.\n" +
            "ابتسامة على شفتيه - رواية 1971.\n" +
            "العمر لحظة - رواية 1973.\n" +
            "أطياف - 1947.\n" +
            "أثنتا عشرة امرأة - 1948.\n" +
            "خبايا الصدور - 1948.\n" +
            "اثنا عشر رجلاً - 1949.\n" +
            "فى موكب الهوى - 1949.\n" +
            "من العالم المجهول - 1949\n" +
            "دى النفوس - 1950.\n" +
            "مبكى العشاق - 1950",
    R.drawable.author_background
)
val b7 = ChildModelClass(
    R.drawable.nagi,
    "نجيب محفوظ",
    "كاتب",
    "نجيب محفوظ عبد العزيز إبراهيم أحمد الباشا (11 ديسمبر 1911 – 30 أغسطس 2006)، والمعروف باسمه الأدبي نجيب محفوظ، هو روائي، وكاتب مصري، يُعد أول أديب عربي حائز على جائزة نوبل في الأدب. كتب نجيب محفوظ منذ الثلاثينات، واستمر حتى 2004. تدور أحداث جميع رواياته في مصر، وتظهر فيها سمة متكررة هي الحارة التي تعادل العالم. من أشهر أعماله: الثلاثية، وأولاد حارتنا، والتي مُنعت من النشر في مصر منذ صدورها وحتى وقتٍ قريب. بينما يُصنف أدب محفوظ باعتباره أدباً واقعياً، فإن مواضيعاً وجودية تظهر فيه. يُعد محفوظ أكثر أديب عربي نُقلت أعماله إلى السينما والتلفزيون.",
    "روايات ومنها  الثلاثية التاريخية ، عبث الأقدار ، رادوبيس ، كفاح طيبة ، القاهرة الجديدة ، خان الخليلي ، زقاق المدق ، السراب ، بداية ونهاية \n" +
            "ثلاثية القاهرة ، بين القصرين ، قصر الشوق السكرية ، اللص والكلاب ، السمان والخريف ، الطريق ، الشحاذ ، ثرثرة فوق النيل ، ميرامار ، أولاد حارتنا ، المرايا  \n" +
            "مجموعات قصصية ومنها همس النجوم ، دنيا الله ، بيت سيء السمعة ، خمارة القط الأسود ، تحت المظلة ، حكاية بلا بداية وبلا نهاية ، شهر العسل ، الجريمة ، الحب فوق هضبة الهرم ، الشيطان يعظ ، رأيت فيما يرى النائم ، التنظيم السري ، صباح الورد ، الفجر الكاذب ،أصداء السيرة الذاتية .",
    R.drawable.author_background
)
val b8 = ChildModelClass(
    R.drawable.tawfik,
    "توفيق الحكيم",
    "كاتب",
    "توفيق الحكيم (1315 هـ / 9 أكتوبر 1898م - 1407 هـ / 26 يوليو 1987)، ولد في الإسكندرية وتوفي في القاهرة. كاتب وأديب مصري، من رواد الرواية والكتابة المسرحية العربية ومن الأسماء البارزة في تاريخ الأدب العربي الحديث، كانت للطريقة التي استقبل بها الشارع الأدبي العربي إنتاجاته الفنية، بين اعتباره نجاحًا عظيمًا تارة وإخفاقا كبيرا تارة أخرى، الأثر الأعظم على تبلور خصوصية تأثير أدب توفيق الحكيم وفكره على أجيال متعاقبة من الأدباء، وكانت مسرحيته المشهورة أهل الكهف في عام 1933 حدثًا هامًا في الدراما العربية فقد كانت تلك المسرحية بدايةً لنشوء تيار مسرحي عرف بالمسرح الذهني. بالرغم من الإنتاج الغزير لتوفيق الحكيم فإنه لم يكتب إلا عدداً قليلاً من المسرحيات التي يمكن تمثيلها على خشبة المسرح فمعظم مسرحياته من النوع الذي كُتب ليُقرأ فيكتشف القارئ من خلاله عالمًا من الدلائل والرموز التي يمكن إسقاطها على الواقع في سهولة لتسهم في تقديم رؤية نقدية للحياة والمجتمع تتسم بقدر كبير من العمق والوعي.",
    "الروايات\n" +
            "1933 – عودة الرّوح\n" +
            "1936 – (طه حسين) القصر المسحور مع \n" +
            "1937 – يوميّات نائب في الأرياف\n" +
            "1938 – عصفور من الشّرق\n" +
            "1938 – أشعب\n" +
            "1939 – راقصة المَعبد روايات قصيرة\n" +
            "1940 – حمار الحكيم\n" +
            "1944 – الرّباط المُقدس\n" +
            "القصص\n" +
            "1938 – عهد الشّيطان قصص\n" +
            "1941 – سلطان الظّلام قصص\n" +
            "1953 – عدالة وفن قصص\n" +
            "1953 – أرني الله قصص",
    R.drawable.author_background
)

val mostPopular6 = arrayListOf(b1, b2, b3, b4, b5, b6, b7, b8)
val searchArrayList =
    arrayListOf(
        "أحمد خالد توفيق",
        "طه حسين",
        "حنان لاشين",
        "اجاثا كريستي",
        "عمرو عبد الحميد",
        "يوسف السباعي",
        "نجيب محفوظ",
        "توفيق الحكيم"
    )
