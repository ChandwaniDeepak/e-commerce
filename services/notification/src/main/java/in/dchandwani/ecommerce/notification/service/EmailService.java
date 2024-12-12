package in.dchandwani.ecommerce.notification.service;

import in.dchandwani.ecommerce.kafka.order.Products;
import in.dchandwani.ecommerce.notification.model.EmailTemplate;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
//    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(String destinationEmail, String customerName,
                                        BigDecimal amount, String orderReference){

//        final String templateName = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();
//        log.info(String.format("Email successfully sent to %s with template %s", destinationEmail, templateName));
        log.info(String.format("Email successfully sent to %s", destinationEmail));
    }
    @Async
    public void sendOrderConfirmationEmail(String destinationEmail, String customerName,
                                           BigDecimal amount, String orderReference, List<Products> products) {
//        final String templateName = EmailTemplate.ORDER_CONFIRMATION.getTemplate();
//        log.info(String.format("Email successfully sent to %s with template %s", destinationEmail, templateName));
        log.info(String.format("Email successfully sent to %s", destinationEmail));
    }


//    @Async
//    public void sendPaymentSuccessEmail(String destinationEmail, String customerName,
//                                        BigDecimal amount, String orderReference) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
//                MimeMessageHelper.MULTIPART_MODE_RELATED,
//                StandardCharsets.UTF_8.name());
//
//        messageHelper.setFrom("contact@dchandwani.in");
//        final String templateName = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();
//
//        Map<String, Object> vars = new HashMap<>();
//        vars.put("customerName", customerName);
//        vars.put("amount", amount);
//        vars.put("orderReference", orderReference);
//
//        Context context = new Context();
//        context.setVariables(vars);
//
//        messageHelper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());
//
//        try{
//            String htmlTemplate = templateEngine.process(templateName, context);
//            messageHelper.setText(htmlTemplate, true);
//
//            messageHelper.setTo(destinationEmail);
//            mailSender.send(mimeMessage);
//            log.info(String.format("Email successfully sent to %s with template %s", destinationEmail, templateName));
//
//        } catch (MessagingException messagingException){
//            logException(messagingException, destinationEmail);
//        }
//    }

//    @Async
//    public void sendOrderConfirmationEmail(String destinationEmail, String customerName,
//                                           BigDecimal amount, String orderReference, List<Products> products) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
//                MimeMessageHelper.MULTIPART_MODE_RELATED,
//                StandardCharsets.UTF_8.name());
//
//        messageHelper.setFrom("contact@dchandwani.in");
//        final String templateName = EmailTemplate.ORDER_CONFIRMATION.getTemplate();
//
//        Map<String, Object> vars = new HashMap<>();
//        vars.put("customerName", customerName);
//        vars.put("totalAmount", amount);
//        vars.put("orderReference", orderReference);
//        vars.put("products", products);
//
//        Context context = new Context();
//        context.setVariables(vars);
//
//        messageHelper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());
//
//        try {
//            String htmlTemplate = templateEngine.process(templateName, context);
//            messageHelper.setText(htmlTemplate, true);
//
//            messageHelper.setTo(destinationEmail);
//            mailSender.send(mimeMessage);
//            log.info(String.format("Email successfully sent to %s with template %s", destinationEmail, templateName));
//
//        } catch (MessagingException messagingException) {
//            logException(messagingException, destinationEmail);
//        }
//    }
//    private void logException(MessagingException messagingException, String destinationEmail){
//        log.warn("Cannot send email to {}, because of {}", destinationEmail, messagingException.getMessage());
//    }
}
