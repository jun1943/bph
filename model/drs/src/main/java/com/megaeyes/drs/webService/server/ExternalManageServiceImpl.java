package com.megaeyes.drs.webService.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.megaeyes.drs.bean.CjdbBean;
import com.megaeyes.drs.bean.CjryBean;
import com.megaeyes.drs.bean.Jjdb110Bean;
import com.megaeyes.drs.bean.XlzBean;
import com.megaeyes.drs.domain.PatrolGroup;
import com.megaeyes.drs.domain.PoliceUser;

@Component
@WebService(serviceName = "ExternalManageService", endpointInterface = "com.megaeyes.drs.webService.server.ExternalManageService")
@javax.xml.ws.soap.MTOM(enabled = true, threshold = 1024 * 1024)
public class ExternalManageServiceImpl implements ExternalManageService {

	final static private int size = 1024 * 1024;

	private Log logger = LogFactory.getLog(ExternalManageServiceImpl.class);

	@Override
	public boolean pushCurJjdb110(Jjdb110Bean jjdb110Bean) {
		return true;
	}

	@Override
	public boolean pushCurCjdb(CjdbBean cjdbBean) {
		return true;
	}

	@Override
	public boolean pushCurState(String jjdbh, String cjdbh, Integer zt) {
		return true;
	}

	@Override
	public boolean pushCurCjry(CjryBean cjrybean) {
		return true;
	}

	@Override
	public boolean pushCurXlz(XlzBean xlzbean) {
		return true;
	}

	@Override
	public boolean delCjdb(CjdbBean cjdbBean) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public PatrolGroup getPatrolGroupByRegionId(String regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliceUser> findUsersByOrganCode(String platformId,
			String organCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatrolGroup> findPatrolGroupByOrganCode(String platformId,
			String organCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upload(DataHandler dataHandler) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File file = new File("D:\\ad.txt");
			in = dataHandler.getInputStream();
			out = new FileOutputStream(file);
			byte[] buf = new byte[size];
			int read;
			while ((read = in.read(buf)) != -1) {
				out.write(buf, 0, read);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static File getFileDepository() {
		return new File(System.getProperty("java.io.tmpdir"));
	}

	@Override
	public DataHandler downLoad(String fileName) throws FileNotFoundException {
		// if (fileName == null || fileName.isEmpty()) {
		// throw new FileNotFoundException("file name is null");
		// }
		File dir = getFileDepository();

		File downLoadFile = new File("D:\\QQ图片20150104105643.jpg");
		if (!downLoadFile.exists()) {
			throw new FileNotFoundException("file name is null");
		}
		return new DataHandler(new FileDataSource(downLoadFile));
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.io.tmpdir"));
		;
	}
}
