<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hema.medical_backend_spring.mapper.HelperDto" %>
<%@ page import="com.hema.medical_backend_spring.model.Doctor.Specialty" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Appointment </title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./style.css">
        <link rel="stylesheet" href="./css/appointment.css">
        <link rel="stylesheet" href="./responsive.css">
    </head>
    <body>
        <div class="container">
            <%@ include file="shared/header.jsp" %>
            <section class="text-center">
                <div class="flex-column">
                    <div class="icon-holder">
                        <img src="/svgs/calender.svg" alt="icon"/>
                    </div>
                    <div>
                        <h1 class="text-primary">
                            نموذج حجز المواعيد أونلاين
                        </h1>
                        <div class="app-hr"><span class="footer-hr"></span></div>
                        <p class="text-secondary">
                            يسعدنا انضمامكم لمركزنا. يرجى تعبئة البيانات المطلوبة بدقة لضمان حصولكم على أفضل
                            <br>
                            رعاية طبية في الموعد المفضل.
                        </p>
                    </div>
                    <div class="form row">
                        <div class="top-gradient"></div>
                        <form  method="post" action="/book-appointment">
                            <div class="flex text-primary mb-2 mt-2" >
                                <img src="/svgs/doc-thing.svg" style="margin-inline:8px;"/>
                                تحديد الخدمة الطبية
                            </div>

                            <%-- <%= sp.name().equals(service.getSpecialization().toString()) ? "selected" : "" %> --%>
                            <div class="row justify-content-around">
                                <div class="mb-3 col-md-5">
                                    <label for="specialization" class="form-label"> القسم / التخصص </label>
                                    <select class="form-control" name="specialization" id="specialization">
                                        <option>اختر القسم المطلوب</option>
                                        <%
                                            for (Specialty sp : Specialty.values()) {
                                            %>
                                            <option value="<%= sp.name() %>" >
                                                <%= HelperDto.getSpecialtyString(sp) %>

                                            </option>
                                            <%
                                            }
                                        %>
                                    </select>
                                </div>



                                <div class="mb-3 col-md-5">
                                    <label for="doctor_id" class="form-label"> الطبيب المختص </label>
                                    <select class="form-control" id="doctor_id" name="doctorId">
                                        <option >اختر الطبيب المفضل</option>
                                    </select>
                                </div>

                                <div class="mb-3 col-md-11 mx-auto">
                                    <label for="service_id" class="form-label"> الخدمة الطبية </label>
                                    <select class="form-control" id="service_id" name="serviceId">
                                        <option >اختر الخدمه المناسبه</option>
                                    </select>
                                </div>
                            </div>

                            <div class="flex text-primary mb-2 mt-2 " >
                                <img src="/svgs/date-out.svg" style="margin-inline:8px;"/>
                                الموعد المقترح
                            </div>

                            <div class="row justify-content-around">

                                <div class="mb-3 col-md-5">
                                    <label for="appointmentDate" class="form-label">تاريخ الزيارة</label>
                                    <input type="date" class="form-control" id="appointmentDate" name="appointmentDate" disabled>


                                    <div class="note mt-4 text-secondary flex">
                                        <img src="./svgs/info.svg" alt="icon" />
                                        المواعيد تخضع للتأكيد النهائي من خلال اتصال قسم المواعيد بكم.
                                    </div>

                                </div>



                                <div class="mb-3 col-md-5">
                                    <div id="time-slots-container" style="display:none" class="mt-3">
                                        <label class="form-label">الفترات المتاحة</label>
                                        <div class="row justify-content-between">
                                            <label class="time-slot col-md-5 mb-3">
                                                <input type="radio" name="appointmentTime" value="09:00" hidden>
                                                ص 9:00
                                            </label>
                                            <label class="time-slot col-md-5 mb-3">
                                                <input type="radio" name="appointmentTime" value="11:30" hidden>
                                                ص 11:30
                                            </label>
                                            <label class="time-slot col-md-5 mb-3">
                                                <input type="radio" name="appointmentTime" value="16:30" hidden>
                                                م 4:30
                                            </label>
                                            <label class="time-slot col-md-5 mb-3">
                                                <input type="radio" name="appointmentTime" value="19:00" hidden>
                                                م 7:00
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="mb-3 mt-3">
                                    <label for="notes" class="form-label text-primary">ملاحظات طبية إضافية</label>
                                    <textarea class="form-control" id="notes" name="notes" rows="5" placeholder="يرجى كتابة أي ملاحظات أو استفسارات طبية ترغب في مشاركتها مع الطبيب..."></textarea>
                                </div>
                            </div>

                            <div class="row mb-5 mt-5 justify-content-around">
                                <p class="text-secondary col-md-5">
                                    بتقديم هذا الطلب، فإنك توافق على سياسة الخصوصية الخاصة
                                    <br>
                                    بالمركز الطبي واستخدام بياناتك لأغراض جدولة المواعيد.
                                </p>
                                <button type="submit" class="btn-primary col-md-4"  >  تأكيد طلب الحجز
                                    <img src="./svgs/appointment.svg" alt="icon" style="margin-right: 16px;">
                                </button>
                            </div>
                        </form>
                    </div>
                </section>
                <section class="row justify-content-around features-section">

                    <div class="flex-column  col-md-3 ">
                        <div class="feature-icon mb-4">
                            <img src="/svgs/certification.svg" alt="icon"/>
                        </div>

                        <h4 class="text-primary">شهادات عالمية</h4>
                        <p class="text-secondary">معايير جودة طبية تتوافق مع البروتوكولات العالمية
                        </p>
                    </div>
                    <div class="flex-column  col-md-3 text-center ">
                        <div class="feature-icon mb-4">
                            <img src="/svgs/privacy.svg" alt="icon"/>
                        </div>
                        <h4 class="text-primary"> خصوصية تامة</h4>
                        <p class="text-secondary">بياناتكم الطبية مشفرة ومحفوظة بأعلى درجات السرية
                        </p>
                    </div>
                    <div class="flex-column  col-md-3 ">
                        <div class="feature-icon mb-4">
                            <img src="/svgs/support.svg" alt="icon"/>
                        </div>

                        <h4 class="text-primary"> دعم متواصل</h4>
                        <p class="text-secondary">
                            فريق التنسيق الطبي متاح للإجابة على اتصالاتكم
                        </p>
                    </div>
                </section>

            </div>
            <%@ include file="shared/footer.jsp" %>
            <script src="./js/bootstrap.min.js"></script>
            <script>
                const doctorSelect = document.getElementById("doctor_id");
                const serviceSelect = document.getElementById("service_id");
                document.getElementById("specialization").addEventListener("change", function() {
                    const specialization = this.value;
                    
                    // reset
                    doctorSelect.innerHTML = "<option>اختر الطبيب المفضل</option>";
                    serviceSelect.innerHTML = "<option>اختر الخدمة المطلوبة</option>";
                    document.getElementById("appointmentDate").disabled = true;
                    document.getElementById("time-slots-container").style.display = "none";
                    
                    if (this.value === "اختر القسم المطلوب") return;
                    
                    // loading
                    doctorSelect.innerHTML = "<option>جاري التحميل...</option>";
                    doctorSelect.disabled = true;
                    serviceSelect.innerHTML = "<option>جاري التحميل...</option>";
                    serviceSelect.disabled = true;
                    
                    // fetch doctors and services together
                    
                    fetch("/api/doctors?specialization=" + specialization).then(r => r.json())
                    .then((doctors) => {
                        // doctors
                        doctorSelect.innerHTML = "<option>اختر الطبيب المفضل</option>";
                        if (doctors.length === 0) {
                            doctorSelect.innerHTML = "<option>لا يوجد أطباء في هذا التخصص</option>";
                            serviceSelect.innerHTML = "<option>لا يوجد طبيب لهذه الخده الان</option>";
                            serviceSelect.disabled = false;
                        } else {
                            doctors.forEach(d => {
                                const opt = document.createElement("option");
                                opt.value = d.id;
                                opt.textContent = d.fullName;
                                doctorSelect.appendChild(opt);
                            });
                            fetchServices(specialization);
                        }
                        
                    })
                    .catch(() => {
                        doctorSelect.innerHTML = "<option>حدث خطأ، حاول مرة أخرى</option>";
                        serviceSelect.innerHTML = "<option>حدث خطأ، حاول مرة أخرى</option>";
                    })
                    .finally(() => {
                        doctorSelect.disabled = false;
                        serviceSelect.disabled = false;
                    });
                });
                
                let bookedDates = [];
                
                function checkEnableDatePicker() {
                    const doctorId = document.getElementById("doctor_id").value;
                    const serviceId = document.getElementById("service_id").value;
                    
                    if (doctorId === "اختر الطبيب المفضل" ||
                    serviceId === "اختر الخدمة المطلوبة") return;
                    
                    const dateInput = document.getElementById("appointmentDate");
                    const today = new Date().toISOString().split("T")[0];
                    dateInput.min = today;
                    dateInput.disabled = false;
                    
                    // جيب الأيام المحجوزة
                    fetch("/api/appointments/booked-dates?doctorId=" + doctorId)
                    .then(r => r.json())
                    .then(dates => {
                        bookedDates = dates;
                    });
                }
                
                document.getElementById("doctor_id").addEventListener("change", checkEnableDatePicker);
                document.getElementById("service_id").addEventListener("change", checkEnableDatePicker);
                document.getElementById("appointmentDate").addEventListener("change", function() {
                    const selected = this.value;
                    const doctorId = document.getElementById("doctor_id").value;
                    const slotsContainer = document.getElementById("time-slots-container");
                    
                    // reset slots
                    slotsContainer.style.display = "none";
                    document.querySelectorAll(".time-slot").forEach(s => {
                        s.classList.remove("time-slot-disabled");
                        s.querySelector("input[type='radio']").checked = false;
                    });
                    
                    // لو اليوم محجوز بالكامل
                    if (bookedDates.includes(selected)) {
                        this.setCustomValidity("هذا اليوم محجوز بالكامل، اختر يوم آخر");
                        this.reportValidity();
                        this.value = "";
                        return;
                    }
                    
                    this.setCustomValidity("");
                    
                    // جيب الـ slots المحجوزة في اليوم ده
                    fetch("/api/appointments/available-slots?doctorId=" + doctorId + "&date=" + selected)
                    .then(r => r.json())
                    .then(bookedSlots => {
                        slotsContainer.style.display = "block";
                        
                        document.querySelectorAll(".time-slot").forEach(slot => {
                            const value = slot.querySelector("input[type='radio']").value;
                            if (bookedSlots.includes(value)) {
                                slot.classList.add("time-slot-disabled");
                            }
                        });
                    });
                });
                document.querySelectorAll(".time-slot").forEach(slot => {
                    slot.addEventListener("click", function() {
                        // لو محجوز متعملش حاجة
                        if (this.classList.contains("time-slot-disabled")) return;
                        
                        // شيل active من الكل
                        document.querySelectorAll(".time-slot").forEach(s => {
                            s.classList.remove("time-slot-active");
                        });
                        
                        // حط active على اللي اتضغط
                        this.classList.add("time-slot-active");
                        
                        // حدد الـ radio button
                        this.querySelector("input[type='radio']").checked = true;
                    });
                });
                
                
                function fetchServices(specialization,isDoctor){
                    
                    // fetch services
                    fetch("/api/services?specialization=" + specialization)
                    .then(res => res.json())
                    .then(services => {
                        serviceSelect.innerHTML = "<option>اختر الخدمة المطلوبة</option>";
                        
                        if (services.length === 0) {
                            serviceSelect.innerHTML = "<option>لا يوجد خدمات في هذا التخصص</option>";
                            return;
                        }
                        
                        services.forEach(service => {
                            const option = document.createElement("option");
                            option.value = service.id;
                            option.textContent = service.name + " - " + (service.consulating ? "استشاره "+service.consulating + " ر.س" : service.startFrom ? "يبدا من " +service.startFrom + " ر.س" : service.price ? "سعر الكشف  "+service.price + " ر.س" : "");
                            serviceSelect.appendChild(option);
                        });
                    })
                    .catch(() => {
                        serviceSelect.innerHTML = "<option>حدث خطأ، حاول مرة أخرى</option>";
                    })
                    .finally(() => serviceSelect.disabled = false);
                }
            </script>

        </body>
    </html>
