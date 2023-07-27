package ru.ssilurs.testTask;

import java.util.HashMap;
import java.util.Map;

public class Source {
    public static void main(String[] args) {
        Map<String, String> yesterdayState = new HashMap<>() {{
            put("url1", "html1");
            put("url2", "html2");
            put("url3", "html3");
            put("url", "html");
        }};

        Map<String, String> todayState = new HashMap<>() {{
            put("url1", "html1");
            put("url2", "hml2");
            put("url3", "hml3");
            put("url4", "html4");
        }};

        StringBuilder emailContent = new StringBuilder()
                .append("Здравствуйте, дорогая и.о. секретаря\n\n")
                .append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n")
                .append("Исчезли следующие страницы:\n");

        yesterdayState
                .keySet()
                .stream()
                .filter(s ->
                        !todayState.containsKey(s))
                .forEach(s ->
                        emailContent.append(s).append("\n")
                );

        emailContent.append("\nПоявились следующие новые страницы:\n");
        todayState
                .keySet()
                .stream()
                .filter(url ->
                        !yesterdayState.containsKey(url))
                .forEach(url ->
                        emailContent.append(url).append("\n")
                );

        emailContent.append("\nИзменились следующие страницы:\n");
        yesterdayState
                .keySet()
                .stream()
                .filter(url ->
                        todayState.containsKey(url) && !yesterdayState.get(url).equals(todayState.get(url))
                )
                .forEach(url ->
                        emailContent.append(url).append("\n")
                );

        System.out.println(emailContent);
    }
}
