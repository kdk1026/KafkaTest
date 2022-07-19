package kr.co.test.common.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

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
public class MyKafkaConsumer {

	private Properties props;

	/**
	 *
	 */
//	public MyKafkaConsumer(Properties props) {
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

	public String receive() {
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList(props.getProperty("topic")));

		String msg = "";
		while (true) {
			ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
			for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
				msg += consumerRecord.value();
			}
			consumer.close();
			return msg;
		}
	}
}
