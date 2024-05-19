package in.sampath.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

	private Logger logger = LoggerFactory.getLogger(MsgService.class);

	public String getWelcomeMsg() {

//		logger.info("getWelcomeMsg() --started...");

		logger.error("this is error message....");

		logger.warn("this is Warning massage..");

		logger.debug("this is debug massage..");

		logger.trace("This is trace msg...");

//		logger.info("getWelcomeMsg()---ended");
		String msg = "Welcome to my app";

		return msg;
	}

}
