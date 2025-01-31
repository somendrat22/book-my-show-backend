package com.bookmyshow_mail.book_my_show_mail.utility;

import com.bookmyshow_mail.book_my_show_mail.requestbody.Booking;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailUtility {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendMail(
            String subjectLine,
            String mailType,
            String toEmail,
            String userName
    ) throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("userName", userName);
        mimeMessageHelper.setSubject(subjectLine);
        mimeMessageHelper.setTo(toEmail);
        String htmlEmail = templateEngine.process("user-registration-email", context);
        mimeMessageHelper.setText(htmlEmail, true);
        javaMailSender.send(mimeMessage);
    }


    public void sendThreaterRegistrationMail(String toEmail, String ownerName, String address, String subjectLine) throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("userName", ownerName);
        context.setVariable("address", address);
        mimeMessageHelper.setSubject(subjectLine);
        mimeMessageHelper.setTo(toEmail);
        String htmlEmail = templateEngine.process("threater-registration-mail", context);
        mimeMessageHelper.setText(htmlEmail, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendHallRegistrationMail(String toEmail,
                                         String ownerName,
                                         String location,
                                         int seats,
                                         String subjectLine) throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("ownerName", ownerName);
        context.setVariable("hallSeats", seats);
        context.setVariable("theaterLocation", location);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subjectLine);
        String htmlFile  = templateEngine.process("hall-registration-mail", context);
        mimeMessageHelper.setText(htmlFile, true);
        javaMailSender.send(mimeMessage);

    }


    public void sendBookingMail(Booking booking) throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        Context context = new Context();
        context.setVariable("userName", booking.getUserName());
        context.setVariable("userEmail", booking.getUserEmail());
        context.setVariable("totalTickets", booking.getTotalTickets());
        context.setVariable("totalAmountPaid", booking.getTotalAmountPaid());
        context.setVariable("paymentMethod", booking.getPaymentMethod());
        context.setVariable("hallName", booking.getHallName());
        context.setVariable("theaterName", booking.getTheaterName());
        context.setVariable("theaterAddress", booking.getTheaterAddress());

        mimeMessageHelper.setTo(booking.getUserEmail());
        mimeMessageHelper.setSubject("Booking Confirmation - " + booking.getTheaterName());
        String htmlFile  = templateEngine.process("booking-mail", context);
        mimeMessageHelper.setText(htmlFile, true);
        javaMailSender.send(mimeMessage);
    }

}
