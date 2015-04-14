package com.tianyi.bph.gps.adapter;


import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
//import java.nio.charset.Charset;
//import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

//import com.megaeyes.support.ResultHandler;

public class MessageDecoder extends CumulativeProtocolDecoder {

	private static final CharsetDecoder DEFAULT_DECODER = Charset.forName(
			"GBK").newDecoder();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.mina.filter.codec.CumulativeProtocolDecoder#doDecode(org.apache
	 * .mina.core.session.IoSession, org.apache.mina.core.buffer.IoBuffer,
	 * org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		// in.order(ByteOrder.BIG_ENDIAN);
		// ResultHandler handler = new ResultHandler();
		// handler.setHeaders(in);
		// out.write(handler);
		// return true;
		
		in.order(ByteOrder.LITTLE_ENDIAN); // 瀛楄妭搴� Constants.ByteEndian =
		in.setAutoExpand(true);
		out.write(in.getString(DEFAULT_DECODER));
		return true;

	}
}
