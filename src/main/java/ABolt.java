import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

class ABolt extends BaseBasicBolt {
	static final Logger logger = Logger.getLogger("fizzbuzz");

	public ABolt() throws SecurityException, IOException {
	 this.logger.info("Opening log");
	}

	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector){
		this.logger.info("Received tuple: " + tuple.getIntegerByField("better number"));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer){
		declarer.declare(new Fields());
	}
}

