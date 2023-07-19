package com.techtx.main;

import java.io.File;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {
	
	public TelegramBot() {
		super("5972132570:AAEGZit2aZdSub6hgMI6g02l8Y9UyD-HCjk");
	}

	@Override
	public void onUpdateReceived(Update update) {
		
		String text = update.getMessage().getText();
		
		Long chatId = update.getMessage().getChatId();
		
		//SendMessage sendMessage = new SendMessage();
		//sendMessage.setChatId(chatId);
		//sendMessage.setText("Hello");
		
		InputFile file = new  InputFile();
		file.setMedia(new File("E:\\test\\test\\old-man.jpg"));
		
		SendPhoto photo = new SendPhoto();
		photo.setChatId(chatId);
		photo.setPhoto(file);
		try {
			execute(photo);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(text);



	}

	@Override
	public String getBotUsername() {

		return "TamilTestBot";
	}

}