package SpringWeb.service;

import SpringWeb.dao.RankDao;
import SpringWeb.dao.UserMapper;
import SpringWeb.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//使用Service注解方式声明服务，将@autowired注解的对象声明成依赖对象
//当将类声明为service时，该类当作bean管理（意为将该类放入Spring bean容器中）
//默认情况下，每一个bean是单例模式的即为只有一个实例对象
//自定义形式 使用@Configuration
@Service
public class RankService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RankDao rankDao;
    public List<RankItem> getRank(){
        return rankDao.getRank();
    }
}
