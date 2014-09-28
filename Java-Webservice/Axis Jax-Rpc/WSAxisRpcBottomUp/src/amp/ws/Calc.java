package amp.ws;

import amp.ws.bean.CalcReq;
import amp.ws.bean.CalcResp;

public class Calc {
	public CalcResp calc(CalcReq calcReq){
		CalcResp calcResp = new CalcResp();
		calcResp.setSum(calcReq.getOper1() + calcReq.getOper2());
		calcResp.setDiff(calcReq.getOper1() - calcReq.getOper2());
		calcResp.setMul(calcReq.getOper1() * calcReq.getOper2());
		calcResp.setDiv(calcReq.getOper1() / calcReq.getOper2());
		return calcResp;
	}
}
