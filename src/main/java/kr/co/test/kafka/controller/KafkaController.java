package kr.co.test.kafka.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.test.common.kafka.MyKafkaConsumer;
import kr.co.test.common.kafka.MyKafkaProducer;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2022. 7. 19. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@Controller
public class KafkaController {

	@Autowired
	private MyKafkaProducer producer;

	@Autowired
	private MyKafkaConsumer consumer;

	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {
		System.out.println("--------welcome--------");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/kafka/welcome");
		return mv;
	}

	@RequestMapping(value = "/sendmessage", method = RequestMethod.GET)
	public ModelAndView sendMessage() {
		System.out.println("--------sendmessage--------");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(date);

		ModelAndView mv = new ModelAndView();
		mv.addObject("time", now);
		mv.setViewName("/kafka/kafka_send");
		return mv;
	}

	@RequestMapping(value = "/onsend", method = RequestMethod.POST)
	public ModelAndView onsend(@RequestParam("message") String msg) {
		System.out.println("--------onsend--------");
		producer.sendMessage(msg);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/kafka/welcome");
		return mv;
	}

	@RequestMapping(value = "/receive")
	public ModelAndView receive() {
		System.out.println("--------receive--------");

		String msg = consumer.receive();

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.setViewName("/kafka/kafka_receive");
		return mv;
	}

}
