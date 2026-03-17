<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Doctors </title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./style.css">
        <%-- <link rel="stylesheet" href="./css/doctors.css"> --%>
    </head>
    <body>
        <div class="container">
            <%@ include file="shared/header.jsp" %>

            <section>
                <h1 class="text-primary">
                    نخبة
                    <span>الأطباء والمتخصصين</span>
                </h1>
                <p class="text-secondary">
                    جودة الرعاية تبدأ من اختيار الكفاءات. نضع بين أيديكم فريقاً من أمهر
                    <br>
                    الاستشاريين في بيئة طبية فاخرة.
                </p>
                <%-- //TODO add the search  --%>
            </section>

            <section class="section-buttons">
                <button class="btn-primary">الكل  </button>
                <button class="btn-secondary">طب عام  </button>
                <button class="btn-secondary">اسنان  </button>
                <button class="btn-secondary">جلدية </button>
                <button class="btn-secondary">عيون </button>
            </section>
            <section >
                <div class="row justify-content-between">

                    <div class="col-md-3">
                        <div class="card card-doctor" >
                            <div class="tag-in-img">
                                <img src="/images/doc1.png" class="card-img-top" alt="image">
                                <div class="img-tag">
                                    <p class="btn-primary">
                                        <img src="/svgs/star-outlet.svg" alt="star icon">
                                        <span style="color:white;">4.9</span>
                                    </p>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="btn-primary">   القلب والأوعية الدموية </div>
                                <h3 class="text-primary">  د. محمد العلي</h3>
                                <h6 class="text-gold"> استشاري أول - خبرة 15 عاماً</h6>
                                <p class="text-secondary">
                                    متخصص في القسطرة
                                    الدقيقة وتشخيص أمراض...
                                </p>
                                <a href="#" class="btn-gold flex-between">
                                    <p class="text-primary">     احجز مع الطبيب  </p>
                                    <img width="18" src="/svgs/arrow-left-short-dark.svg" alt="icon" />
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card card-doctor" >
                            <div class="tag-in-img">
                                <img src="/images/doc2.png" class="card-img-top" alt="image">
                                <div class="img-tag">
                                    <p class="btn-primary">
                                        <img src="/svgs/star-outlet.svg" alt="star icon">
                                        <span style="color:white;">4.8</span>
                                    </p>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="btn-primary"> الجلدية والتجميل</div>
                                <h3 class="text-primary">  د. سارة المنصور</h3>
                                <h6 class="text-gold"> أخصائية - خبرة 10 أعوام</h6>
                                <p class="text-secondary">خبرة واسعة في الحقن
                                    التجميلي، الليزر، وعلاج الأمرا...
                                </p>
                                <a href="#" class="btn-gold flex-between">
                                    <p class="text-primary">     احجز مع الطبيب  </p>
                                    <img width="18" src="/svgs/arrow-left-short-dark.svg" alt="icon" />
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card card-doctor" >
                            <div class="tag-in-img">
                                <img src="/images/doc3.png" class="card-img-top" alt="image">
                                <div class="img-tag">
                                    <p class="btn-primary">
                                        <img src="/svgs/star-outlet.svg" alt="star icon">
                                        <span style="color:white;">5.0</span>
                                    </p>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="btn-primary">  طب الأطفال</div>
                                <h3 class="text-primary">  د. فهد الراشد</h3>
                                <h6 class="text-gold"> استشاري - خبرة 12 عاماً</h6>
                                <p class="text-secondary">
                                    متخصص في العناية بحديثي
                                    الولادة، متابعة النمو،...
                                </p>
                                <a href="#" class="btn-gold flex-between">
                                    <p class="text-primary">     احجز مع الطبيب  </p>
                                    <img width="18" src="/svgs/arrow-left-short-dark.svg" alt="icon" />
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card card-doctor" >
                            <div class="tag-in-img">
                                <img src="/images/doc4.png" class="card-img-top" alt="image">
                                <div class="img-tag">
                                    <p class="btn-primary">
                                        <img src="/svgs/star-outlet.svg" alt="star icon">
                                        <span style="color:white;">4.5</span>
                                    </p>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="btn-primary"> طب الأسرة   </div>
                                <h3 class="text-primary">  د. نورة السالم</h3>
                                <h6 class="text-gold"> طبيبة أسرة - خبرة 8 أعوام</h6>
                                <p class="text-secondary">
                                    رعاية وقائية شاملة لكافة
                                    أفراد الأسرة، ومتابعة الأمرا...
                                </p>
                                <a href="#" class="btn-gold flex-between">
                                    <p class="text-primary">     احجز مع الطبيب  </p>
                                    <img width="18" src="/svgs/arrow-left-short-dark.svg" alt="icon" />
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
            <section>
            <%-- //TODO green card  --%>
            </section>
        </div>


        <%@ include file="shared/footer.jsp" %>
        <script src="./js/bootstrap.min.js"></script>
    </body>
</html>
