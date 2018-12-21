package com.roskill.web.controller;

import com.roskill.common.domain.Computer;
import com.roskill.common.model.Employee;
import com.roskill.service.service.EmployeeService;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by likoguan on 10/03/18.
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    private ZkClient zkClient = new ZkClient("localhost:2181,localhost:2182,localhost:2183");

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create() {
//        Computer computer = new Computer();
//        Employee employee = employeeService.getEmployee(1L);
//        return "Welcome to Roskill !";

        if (!zkClient.exists("/company")) {
            zkClient.createPersistent("/company", "latipay");
        }
        Object obj = zkClient.readData("/company");
        return "OK";
    }

    @RequestMapping(value = "/listen", method = RequestMethod.GET)
    @ResponseBody
    public String listen() {
        zkClient.subscribeDataChanges("/company", new IZkDataListener() {
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("node:" + s + ", data:" + o);
            }

            public void handleDataDeleted(String s) throws Exception {
                System.out.println("node:" + s);
            }
        });
        return "OK";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update() {
        zkClient.writeData("/company", "alibaba");
        return "OK";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String change() {
        zkClient.delete("/company");
        return "OK";
    }
}
