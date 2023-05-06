package br.gov.ac.msemail.consumers;

import br.gov.ac.msemail.dtos.EmailDto;
import br.gov.ac.msemail.models.EmailModel;
import br.gov.ac.msemail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);

        System.out.println("Email status: " + emailModel.getStatusEmail().toString());
    }
}
