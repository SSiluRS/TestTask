package ru.ssilurs.testTask;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Source {
    public static void main(String[] args) {
        Map<String, String> yesterdayState = new HashMap<>();
        Map<String, String> todayState = new HashMap<>();

        yesterdayState.put("url1", "html1");
        yesterdayState.put("url2", "html2");
        yesterdayState.put("url3", "html3");
        yesterdayState.put("url", "html");

        todayState.put("url1", "html1");
        todayState.put("url2", "hml2");
        todayState.put("url3", "hml3");
        todayState.put("url4", "html4");

        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Здравствуйте, дорогая и.о. секретаря\n\n");
        emailContent.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n");

        emailContent.append("Исчезли следующие страницы:\n");
        for (String url : yesterdayState.keySet()) {
            if (!todayState.containsKey(url)) {
                emailContent.append(url).append("\n");
            }
        }

        emailContent.append("\nПоявились следующие новые страницы:\n");
        for (String url : todayState.keySet()) {
            if (!yesterdayState.containsKey(url)) {
                emailContent.append(url).append("\n");
            }
        }

        emailContent.append("\nИзменились следующие страницы:\n");
        for (String url : yesterdayState.keySet()) {
            if (todayState.containsKey(url) && !yesterdayState.get(url).equals(todayState.get(url))) {
                emailContent.append(url).append("\n");
            }
        }

        System.out.println(emailContent.toString());
    }
}
