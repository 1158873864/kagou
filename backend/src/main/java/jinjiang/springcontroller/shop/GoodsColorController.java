package jinjiang.springcontroller.shop;

import io.swagger.annotations.ApiOperation;
import jinjiang.blservice.shop.GoodsColorBlService;
import jinjiang.entity.shop.GoodsColor;
import jinjiang.exception.NotExistException;
import jinjiang.response.Result;
import jinjiang.response.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goodsColor")//商品颜色
public class GoodsColorController {

    private final GoodsColorBlService goodsColorBlService;

    @Autowired
    public GoodsColorController(GoodsColorBlService goodsColorBlService) {
        this.goodsColorBlService = goodsColorBlService;
    }

    @ApiOperation(value = "新增商品颜色", notes = "")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Result> addUser(@Valid @RequestBody GoodsColor goodsColor) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsColorBlService.addGoodsColor(goodsColor));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result), HttpStatus.OK);
    }

    @ApiOperation(value = "删除商品颜色", notes = "")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> deleteUserById(@RequestParam("id") String id) throws NotExistException {
        goodsColorBlService.deleteGoodsColor(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找商品颜色", notes = "")
    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getUserById(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsColorBlService.findById(id));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }
}
