package com.example.mybot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MainActivity extends AppCompatActivity {

    private static final String BOT_TOKEN = "5299054710:AAE4t8vHJNwGNUHrM5epVC6-emdSd0eXnsk";
    private static final String CHAT_ID = "-728814149";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }

    public void test_click(View v){
        try {
            MyBot bot = new MyBot();
            TelegramBotsApi botsApi  = new TelegramBotsApi(
                    DefaultBotSession.class);

            LongPollingBot bot;
            try {
                botsApi.registerBot(new TelegramLongPollingBot() {

                    @Override
                    public void onUpdateReceived(Update update) {
                        Message message = update.getMessage();
                        Long chatId = message.getChatId();
                        String input = message.getText();

                        SendMessage request = new SendMessage();
                        request.setChatId(chatId.toString());
                        request.setText("Have a calzone!");
                        try {
                            execute(request);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public String getBotUsername() {
                        return "testBot";
                    }

                    @Override
                    public String getBotToken() {
                        return BOT_TOKEN;
                    }
                });
            }
            catch (Exception e){
                //e.printStackTrace();
            }

        }
        catch (Exception e){
           // e.printStackTrace();
        }
    }
}