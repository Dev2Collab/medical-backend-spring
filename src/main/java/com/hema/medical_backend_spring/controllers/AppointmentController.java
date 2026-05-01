package com.hema.medical_backend_spring.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hema.medical_backend_spring.dto.AppointmentDto;
import com.hema.medical_backend_spring.services.AppointmentService;

import lombok.AllArgsConstructor;



@Controller
@RequestMapping("/book-appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping()
    public String getMethodName() {
        return new String("appointment");
    }


    @PostMapping("")
    public String bookAppointment(@ModelAttribute AppointmentDto dto, Principal principal) {
        appointmentService.createAppointment(dto, principal.getName());
        return "redirect:/home#appointments";
    }


    // المريض يحجز
    // @PostMapping
    // @PreAuthorize("hasRole('PATIENT')")
    // public ResponseEntity<AppointmentResponse> book(
    //         @RequestBody @Valid AppointmentRequest request,
    //         @AuthenticationPrincipal ProjectUser user) {
    //     return ResponseEntity.status(HttpStatus.CREATED)
    //             .body(appointmentService.book(request, user));
    // }

    // // المريض يشوف حجوزاته
    // @GetMapping("/my")
    // @PreAuthorize("hasRole('PATIENT')")
    // public ResponseEntity<List<AppointmentResponse>> getMyAppointments(
    //         @AuthenticationPrincipal ProjectUser user) {
    //     return ResponseEntity.ok(appointmentService.getPatientAppointments(user));
    // }

    // // الدكتور يشوف مواعيده
    // @GetMapping("/doctor")
    // @PreAuthorize("hasRole('DOCTOR')")
    // public ResponseEntity<List<AppointmentResponse>> getDoctorAppointments(
    //         @AuthenticationPrincipal ProjectUser user) {
    //     return ResponseEntity.ok(appointmentService.getDoctorAppointments(user));
    // }

    // // الدكتور يأكد الحجز
    // @PatchMapping("/{id}/confirm")
    // @PreAuthorize("hasRole('DOCTOR')")
    // public ResponseEntity<Void> confirm(@PathVariable Long id,
    //         @AuthenticationPrincipal ProjectUser user) {
    //     appointmentService.confirm(id, user);
    //     return ResponseEntity.ok().build();
    // }

    // // المريض أو الأدمن يلغي
    // @PatchMapping("/{id}/cancel")
    // @PreAuthorize("hasRole('PATIENT') or hasRole('ADMIN')")
    // public ResponseEntity<Void> cancel(@PathVariable Long id,
    //         @AuthenticationPrincipal ProjectUser user) {
    //     appointmentService.cancel(id, user);
    //     return ResponseEntity.ok().build();
    // }
    
}
