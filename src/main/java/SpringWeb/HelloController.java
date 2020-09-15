package SpringWeb;

import SpringWeb.anno.Cache;
import SpringWeb.entity.RankItem;

import SpringWeb.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//MVC
//Moder(数据) View(数据展示样式 html/xml...) Controller(控制如何展示)
@RestController
public class HelloController {
//    @Autowired
//    private UserMapper userMapper;
    @Autowired
    private RankService rankService;

//    @RequestMapping("/")
//    public String search(@RequestParam("q") String data,@RequestParam(value="charset",required = false)String charst) {
//        return "<h1>车市</h1>";
//    }
//http 响应
    @RequestMapping("/let")
    @ResponseBody
    public Object let(HttpServletRequest request , HttpServletResponse response) {
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        System.out.println("测试");

        return rankService.getRank();
    }


    @RequestMapping("/")
    public ModelAndView index() {
        List<RankItem> items=rankService.getRank();
        HashMap <String,Object> model =new HashMap<>();
        model.put("items",items);
        return new ModelAndView("index",model);
    }

    @RequestMapping("/searchJson")
    @ResponseBody
    public Object searchJson(HttpServletRequest request , HttpServletResponse response) {
        HashMap <String,Object> result =new HashMap<>();
        result.put("结果", Arrays.asList("a","b"));
        return result;
    }
    @RequestMapping("/rankData")
    @ResponseBody
    @Cache
    public Object getRankData(){
        return rankService.getRank();
    }
}