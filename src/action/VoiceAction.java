package action;

import com.opensymphony.xwork2.ActionSupport;
import util.Util;

/**
 * Created by 王一疆 in 2018/7/29
 *
 * @email: lincvic@yahoo.com
 * @Description:
 */
public class VoiceAction extends ActionSupport {
    //Model

    private String voiceText;

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }

    //Excute
    @Override
    public String execute() throws Exception{
        Util util = new Util();
        String ssml = util.ssmlBuilder("zh-CN","wangyijiang1",voiceText);
        int result = util.createRequests(ssml);
        if (result == 200){
            return SUCCESS;
        }
        return ERROR;
    }

}
