package kr.co.test.common.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

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
public class MyKafkaProducer {

	private Properties props;

	/**
	 *
	 */
//	public MyKafkaProducer(Properties props) {
//		super();
//		this.props = props;
//	}

	/**
	 * @return the prop
	 */
	public Properties getProps() {
		return props;
	}

	/**
	 * @param prop the prop to set
	 */
	public void setProps(Properties props) {
		this.props = props;
	}

	public void sendMessage(String msg) {
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

		ProducerRecord<String, String> record = new ProducerRecord<String, String>(props.getProperty("topic"), msg);

		producer.send(record);
		producer.close();
	}

}
