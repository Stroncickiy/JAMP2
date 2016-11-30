package com.epam.websockets.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum MessageType {

	IN {
		@Override
		public String messageToString(Message message) {
			return String.format("[%s:%s] %s", simpleDateFormat.format(message.getTimestamp()), message.getSender(),
					message.getContent());
		}

	},
	AUTH {

		@Override
		public String messageToString(Message message) {
			return String.format("[%s] AUTH | %s", simpleDateFormat.format(new Date()), message.getContent());
		}

	},
	GET_USERS {
		@Override
		public String messageToString(Message message) {
			return String.format("[%s] GET_USERS| %s", simpleDateFormat.format(new Date()), message.getContent());
		}

	},
	OUT {

		@Override
		public String messageToString(Message message) {
			return String.format("[%s:%s] %s", simpleDateFormat.format(new Date()), "ME", message.getContent());
		}

	},
	ERR {

		@Override
		public String messageToString(Message message) {
			return String.format("[%s] Server returned error %s", simpleDateFormat.format(new Date()),
					message.getContent());
		}

	},
	INF {
		@Override
		public String messageToString(Message message) {
			return String.format("[%s] INF| %s", simpleDateFormat.format(new Date()), message.getContent());
		}
	},
	HELP {
		@Override
		public String messageToString(Message message) {
			return String.format("[%s] HELP| %s", simpleDateFormat.format(new Date()), message.getContent());
		}
	};

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

	public abstract String messageToString(Message message);
}
