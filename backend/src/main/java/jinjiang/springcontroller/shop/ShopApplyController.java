package jinjiang.springcontroller.shop;


import io.swagger.annotations.ApiOperation;
import jinjiang.blservice.shop.ShopApplyBlService;
import jinjiang.entity.shop.Shop;
import jinjiang.entity.shop.ShopApply;
import jinjiang.exception.NotExistException;
import jinjiang.response.Result;
import jinjiang.response.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shopApply")
public class ShopApplyController {

    private final ShopApplyBlService shopApplyBlService;

    @Autowired
    public ShopApplyController(ShopApplyBlService shopApplyBlService) {

        this.shopApplyBlService = shopApplyBlService;
    }

    @ApiOperation(value = "新增门店", notes = "新增门店")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Result> addUser(@Valid @RequestBody ShopApply shopApply) throws NotExistException {
        shopApplyBlService.addShopApply(shopApply);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(), HttpStatus.OK);
    }

    @ApiOperation(value = "删除门店", notes = "删除门店")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> deleteUserById(@RequestParam("id") String id) throws NotExistException {
        shopApplyBlService.deleteShopApply(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "修改门店", notes = "修改门店")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Result> updateUserById(@Valid @RequestBody ShopApply shopApply) throws NotExistException {
        shopApplyBlService.updateShopApply(shopApply);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找门店", notes = "")
    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getUserById(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",shopApplyBlService.findById(id));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }


    @ApiOperation(value = "所有门店", notes = "")
    @RequestMapping(value = "/find/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getAllUser(Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",shopApplyBlService.findAll(pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找门店", notes = "")
    @RequestMapping(value = "/find/status", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getUserByStatus(@RequestParam("status") String status,Pageable pageable) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",shopApplyBlService.findByStatus(status,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找门店", notes = "")
    @RequestMapping(value = "pass", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> pass(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        shopApplyBlService.pass(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找门店", notes = "")
    @RequestMapping(value = "dispass", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> dispass(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        shopApplyBlService.dispass(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }


}
