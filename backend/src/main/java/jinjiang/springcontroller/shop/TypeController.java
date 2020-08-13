package jinjiang.springcontroller.shop;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jinjiang.blservice.shop.TypeBlService;
import jinjiang.entity.shop.Shop;
import jinjiang.entity.shop.Type;
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
@RequestMapping("/type")
public class TypeController {

    private final TypeBlService typeBlService;

    @Autowired
    public TypeController(TypeBlService typeBlService) {
        this.typeBlService = typeBlService;
    }

    @ApiOperation(value = "新增门店", notes = "新增门店")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Result> addUser(@Valid @RequestBody Type type) throws NotExistException {
        typeBlService.addType(type);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(), HttpStatus.OK);
    }

    @ApiOperation(value = "删除门店", notes = "删除门店")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> deleteUserById(@RequestParam("id") String id) throws NotExistException {
        typeBlService.deleteType(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "修改门店", notes = "修改门店")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Result> updateUserById(@Valid @RequestBody Type type) throws NotExistException {
        typeBlService.updateType(type);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找门店", notes = "")
    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getUserById(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",typeBlService.findById(id));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }


    @ApiOperation(value = "所有门店", notes = "")
    @RequestMapping(value = "/find/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> find(Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",typeBlService.findAll(pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }
}
