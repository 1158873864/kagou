package jinjiang.springcontroller.shop;

import io.swagger.annotations.ApiOperation;
import jinjiang.blservice.shop.GoodsSizeBlService;
import jinjiang.entity.shop.GoodsSize;
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
@RequestMapping("/goodsSize")//商品尺寸
public class GoodsSizeController {

    private final GoodsSizeBlService goodsSizeBlService;

    @Autowired
    public GoodsSizeController(GoodsSizeBlService goodsSizeBlService) {
        this.goodsSizeBlService = goodsSizeBlService;
    }

    @ApiOperation(value = "新增商品尺寸", notes = "")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Result> addUser(@Valid @RequestBody GoodsSize goodsSize) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsSizeBlService.addGoodsSize(goodsSize));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result), HttpStatus.OK);
    }

    @ApiOperation(value = "删除商品尺寸", notes = "")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> deleteUserById(@RequestParam("id") String id) throws NotExistException {
        goodsSizeBlService.deleteGoodsSize(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找商品尺寸", notes = "")
    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getUserById(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsSizeBlService.findById(id));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }
}
