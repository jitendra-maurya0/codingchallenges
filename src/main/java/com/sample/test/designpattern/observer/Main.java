package com.sample.test.designpattern.observer;

public class Main {

    public static void main(String[] args) {
        EmailTopic emailTopic = new EmailTopic();

        //create observers

        Observer first = new EmailTopicSubscriber("this first observer");
        Observer second = new EmailTopicSubscriber("this second observer");
        Observer third = new EmailTopicSubscriber("this third observer");
        Observer fourth = new EmailTopicSubscriber("this fourth observer");

        emailTopic.register(first);
        emailTopic.register(second);
        emailTopic.register(third);
        emailTopic.register(fourth);

        //attaching observer to subject
        first.setSubject(emailTopic);
        second.setSubject(emailTopic);
        third.setSubject(emailTopic);
        fourth.setSubject(emailTopic);

        //check for update

        first.update();
        third.update();

        //provider/subject (brodcost)

        emailTopic.postMessage("hello Subscriber!");

        emailTopic.unregister(first);
        emailTopic.postMessage("Hello");
    }
}
