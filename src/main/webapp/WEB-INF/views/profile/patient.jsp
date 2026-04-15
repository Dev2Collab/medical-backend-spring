<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Home </title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./style.css">
        <link rel="stylesheet" href="./css/patient.css">
        <link rel="stylesheet" href="./responsive.css">
    </head>
    <body>
        <div class="container">
            <%@ include file="../shared/header.jsp" %>
            <section>
                <div class="content">

                    <div class="card" id="personalDetails">
                        <div class="profile-top">
                            <div class="section-title" style="margin-bottom:0">المعلومات الشخصية</div>
                            <button class="edit-btn"> تعديل الملف</button>
                        </div>
                        <div class="profile-header">
                            <div><img class="avatar" src="./images/${photo}" alt="user photo"> </div>

                            <div class="info-grid">
                                <div class="info-item"><label>الاسم الكامل</label><span> ${user.fullName}</span></div>
                                <div class="info-item"><label>البريد الإلكتروني</label><span>${user.email}</span></div>
                                <div class="info-item"><label>رقم الجوال</label><span>${user.phoneNumber}</span></div>
                                <div class="info-item"><label>تاريخ الميلاد</label><span>${user.dateOfBirth!=null?user.dateOfBirth:"غير محدد"}</span></div>
                                <div class="info-item"><label>الجنس</label><span>${user.gender}</span></div>
                                <div class="info-item"><label>العنوان</label><span>${user.address}</span></div>
                            </div>
                        </div>
                    </div>

                    <!-- Appointments -->
                    <div class="card" id="appointments">
                        <div class="card-title"> مواعيدي القادمة والسابقة</div>
                        <table>
                            <thead><tr>
                                <th>الطبيب</th><th class="special">التخصص</th><th>التاريخ والوقت</th><th>الحالة</th><th>الإجراءات</th>
                            </tr></thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <div style="display:flex;align-items:center;gap:8px">
                                            <div class="doctor-avatar">سأ</div>
                                            <span>د. سارة الأحمد</span>
                                        </div>
                                    </td>
                                    <td class="special">طب القلب</td>
                                    <td>24 أكتوبر 2023 | 10:00 ص</td>
                                    <td><span class="badge badge-green">مؤكد</span></td>
                                    <td><a class="action-link">إدارة الموعد</a></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div style="display:flex;align-items:center;gap:8px">
                                            <div class="doctor-avatar">خف</div>
                                            <span>د. خالد الفيصل</span>
                                        </div>
                                    </td>
                                    <td class="special">الطب العام</td>
                                    <td>12 سبتمبر 2023 | 04:30 م</td>
                                    <td><span class="badge badge-gray">مكتمل</span></td>
                                    <td><a class="action-link">عرض التقرير</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <!-- Medical + Emergency -->
                    <div class="two-col" id="emergency">
                        <div class="card" style="margin-bottom:0">
                            <div class="card-title"> الملف الطبي</div>
                            <div class="card-body">
                                <div class="blood-row">
                                    <span class="text-secondary">
                                        فصيلة الدم
                                    </span>
                                    <span class="blood-badge">A+</span>
                                </div>
                                <div class="medical-row"><span class="medical-label">الحساسية</span><span class="medical-val">حساسية من البنسلين، حساسية الغبار</span></div>
                                <div class="medical-row"><span class="medical-label">الأمراض المزمنة</span><span class="medical-val">ضغط الدم المرتفع (تحت السيطرة)</span></div>
                                <div class="medical-row"><span class="medical-label">الأدوية الحالية</span><span class="medical-val">أملوديبين 5 ملغ (مرة يومياً)</span></div>
                            </div>
                        </div>
                        <div class="card" style="margin-bottom:0">
                            <div class="card-title"> اتصال الطوارئ</div>
                            <div class="card-body">
                                <div class="medical-row"><span class="medical-label">الاسم</span><span class="medical-val">${user.emergencyContactName}</span></div>
                                <div class="medical-row"><span class="medical-label">رقم الجوال</span><span class="medical-val" style="direction:ltr;text-align:right">${user.emergencyContactPhone}</span></div>
                                <div class="emergency-warning">
                                    <div class="medical-row"><span class="medical-label">تنبيه</span><span class="medical-val">
                                        سيتم التواصل مع هذا الرقم فوراً في الحالات الحرجة فقط
                                    </span></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Full Medical Record -->
                    <div class="card" style="margin-top:1rem" id="fullRecord">
                        <div class="card-title"> الملف الطبي الكامل</div>
                        <div class="card-body">
                            <div style="color:#1a3a2a;font-size:13px;font-weight:500;margin-bottom:8px"> سجل التشخيصات</div>
                            <%
                                if(request.getParameter("user.diagnosis") != null){
                                %>
                                <table class="diagnosis-row">
                                    <thead><tr>
                                        <th>التاريخ</th><th>التشخيص</th><th>الطبيب المعالج</th><th>الموقع</th>
                                    </tr></thead>
                                    <tbody>
                                        <tr>
                                            <td>15 أغسطس 2023</td>
                                            <td>التهاب الجيوب الأنفية المزمن</td>
                                            <td>د. محمد القحطاني</td>
                                            <td>فرع حي الصحافة، الرياض</td>
                                        </tr>
                                        <tr>
                                            <td>10 مارس 2023</td>
                                            <td>نزلة برد حادة</td>
                                            <td>د. خالد الفيصل</td>
                                            <td>فرع السليمانية، الرياض</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div style="display:grid;grid-template-columns:1fr 1fr;gap:1rem;margin-top:1rem">
                                <div>
                                    <div style="color:#1a3a2a;font-size:13px;font-weight:500;margin-bottom:8px">📊 نتائج التحاليل</div>
                                    <div class="download-row">
                                        <span class="dl-icon">⬇</span>
                                        <span style="flex:1">تحليل الدم الشامل (CBC)</span>
                                        <div class="flex">
                                            <span class="pdf-icon">PDF</span>
                                            <span style="font-size:11px;color:var(--color-text-secondary); padding-inline:5px">1.2 MB</span>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <div style="color:#1a3a2a;font-size:13px;font-weight:500;margin-bottom:8px">💊 الوصفات الطبية السابقة</div>
                                    <div class="download-row">
                                        <span class="dl-icon">⬇</span>
                                        <span style="flex:1">وصفة طبية - أغسطس 2023</span>
                                        <div class="flex">
                                            <span class="pdf-icon">PDF</span>
                                            <span style="font-size:11px;color:var(--color-text-secondary);padding-inline:5px;">450 KB</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                <%
                                } else {
                                %>
                                <div>no data </div>
                                <%
                                }
                            %>


                        </div>
                    </div>

                    <!-- Notifications + Password -->
                    <div class="two-col">

                        <div class="card" style="margin-bottom:0" id="privacy">
                            <div class="card-title"> تغيير كلمة المرور</div>
                            <div class="card-body">
                                <div class="mb-3" style="width:100%">
                                    <label for="password" class="form-label">كلمة المرور </label>
                                    <div class="input-holder">
                                        <input required type="password" name="password" class="form-control" id="password" placeholder="Enter your password">
                                        <span onclick="togglePassword()"><img src="./svgs/lock.svg" alt="icon"></span>
                                    </div>
                                </div>
                                <div class="mb-3" style="width:100%">
                                    <label for="password" class="form-label">كلمة المرور </label>
                                    <div class="input-holder">
                                        <input required type="password" name="password" class="form-control" id="password" placeholder="Enter your password">
                                        <span onclick="togglePassword()"><img src="./svgs/lock.svg" alt="icon"></span>
                                    </div>
                                </div>

                                <button class="update-btn">🔒 تحديث الأمان</button>
                            </div>
                        </div>

                        <div class="card" style="margin-bottom:0" id="notifications">
                            <div class="card-title">🔔 إعدادات التنبيهات</div>
                            <div class="card-body">
                                <div class="toggle-row">
                                    <div>
                                        <div class="toggle-label">تنبيهات البريد الإلكتروني</div>
                                        <div class="toggle-sub">تقارير طبية وفواتير إلكترونية</div>
                                    </div>
                                    <label class="toggle"><input type="checkbox" checked><span class="toggle-slider"></span></label>
                                </div>
                                <div class="toggle-row">
                                    <div>
                                        <div class="toggle-label">الرسائل النصية SMS</div>
                                        <div class="toggle-sub">تنبيهات المواعيد والتحقق</div>
                                    </div>
                                    <label class="toggle"><input type="checkbox" checked><span class="toggle-slider"></span></label>
                                </div>
                                <div class="toggle-row">
                                    <div>
                                        <div class="toggle-label">تذكر المواعيد</div>
                                        <div class="toggle-sub">قبل 24 ساعة من الموعد</div>
                                    </div>
                                    <label class="toggle"><input type="checkbox"><span class="toggle-slider"></span></label>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <aside class="sidebar">
                    <div class="sidebar-item active">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><circle cx="12" cy="8" r="4"/><path d="M4 20c0-4 3.6-7 8-7s8 3 8 7"/></svg>
                        المعلومات الشخصية
                    </div>
                    <div class="sidebar-item" onclick="window.location ='#appointments'">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><rect x="3" y="4" width="18" height="18" rx="2"/><path d="M16 2v4M8 2v4M3 10h18"/></svg>
                        مواعيدي
                    </div>
                    <div class="sidebar-item" onclick="window.location ='#emergency'">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2"/></svg>
                        السجل الطبي
                    </div>
                    <div class="sidebar-item" onclick="window.location ='#fullRecord'">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8z"/><polyline points="14 2 14 8 20 8"/></svg>
                        الملف الطبي الكامل
                    </div>
                    <div class="sidebar-item" onclick="window.location ='#privacy'">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z"/></svg>
                        الأمان
                    </div>
                    <div class="sidebar-item" onclick="window.location ='#notifications'">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M18 8A6 6 0 006 8c0 7-3 9-3 9h18s-3-2-3-9"/><path d="M13.73 21a2 2 0 01-3.46 0"/></svg>
                        التنبيهات
                    </div>
                    <div class="sidebar-item sidebar-logout" onclick="window.location='/logout'">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                            <path d="M9 21H5a2 2 0 01-2-2V5a2 2 0 012-2h4M16 17l5-5-5-5M21 12H9"/>
                        </svg>
                        تسجيل الخروج
                    </div>
                </aside>
            </section>
        </div>
        <%@ include file="../shared/footer.jsp" %>
        <script src="./js/bootstrap.min.js"></script>
        <script >
            function togglePassword() {
                const input = document.getElementById('password');
                if (input.type === "password") {
                    input.type = "text";
                } else {
                    input.type = "password";
                }
            }
        </script>
    </body>
</html>
