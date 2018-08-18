package io.choerodon.demo.api.controller.v1;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/demo")
public class DemoController {

    @Autowired
    private Information information;

    @GetMapping("/hello")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @ApiOperation(value = "hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello，"+information.getId()+"，"+information.getName(), HttpStatus.OK);
    }
}