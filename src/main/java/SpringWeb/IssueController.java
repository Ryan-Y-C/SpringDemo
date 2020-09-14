package SpringWeb;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("repos")
public class IssueController {
    @DeleteMapping("/{owner}/{repo}/issues/{issueNumber}/lock")
    public void unlock(@PathVariable("owner") String owner,
                       @PathVariable("repo") String repo,
                       @PathVariable("issueNumber") String issueNumber) {
        System.out.println(owner);
        System.out.println(repo);
        System.out.println(issueNumber);
    }
    //接受body方式
    @PostMapping("/{owner}/{repo}/issues")
    public void create(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo,
            @RequestBody() BodyContent object
    ) {
        System.out.println(owner);
        System.out.println(repo);
        System.out.println(object);

    }
    //接受表单方式
    @PostMapping("/tab")
    public void fromTab(@RequestParam("tab") String tab){
        System.out.println(tab);
    }
}
