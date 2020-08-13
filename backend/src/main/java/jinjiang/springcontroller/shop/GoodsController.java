package jinjiang.springcontroller.shop;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jinjiang.blservice.shop.GoodsBlService;
import jinjiang.entity.shop.Goods;
import jinjiang.exception.NotExistException;
import jinjiang.response.Result;
import jinjiang.response.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsBlService goodsBlService;

    @Autowired
    public GoodsController(GoodsBlService goodsBlService) {
        this.goodsBlService = goodsBlService;
    }

    @ApiOperation(value = "新增商品", notes = "新增商品")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Result> addUser(@Valid @RequestBody Goods goods) throws NotExistException {

        goodsBlService.addGoods(goods);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(), HttpStatus.OK);
    }

    @ApiOperation(value = "删除商品", notes = "删除商品")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> deleteUserById(@RequestParam("id") String id) throws NotExistException {
        goodsBlService.deleteGoods(id);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "修改商品", notes = "修改商品")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Result> updateUserById(@Valid @RequestBody Goods goods) throws NotExistException {
        goodsBlService.updateGoods(goods);
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找商品", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String")
    })
    @RequestMapping(value = "/find/id", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getUserById(@RequestParam("id") String id) throws NotExistException {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findById(id));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "所有商品", notes = "")
    @RequestMapping(value = "/find/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> getAllUser(Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findAll(pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "所有商品", notes = "")
    @RequestMapping(value = "/find/query", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> find(@RequestParam("query") String query,Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.find(query,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/shopId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByShopId(@RequestParam("shopId") String shopId,Pageable pageable) throws NotExistException{
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByShopId(shopId,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/typeId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByTypeId(@RequestParam("typeId") String typeId,Pageable pageable){
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByTypeId(typeId,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/typeId-shopId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByTypeIdAndShopId(@RequestParam("typeId") String typeId,@RequestParam("shopId") String shopId,Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByTypeIdAndShopId(typeId,shopId,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/module", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByModule(@RequestParam("module") String module,Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByModule(module,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/module-shopId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByModuleAndShopId(@RequestParam("module") String module,@RequestParam("shopId") String shopId,Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByModuleAndShopId(module,shopId,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/module-typeId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByModuleAndTypeId(@RequestParam("module") String module,@RequestParam("typeId") String typeId,Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByModuleAndTypeId(module,typeId,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找全部商品", notes = "")
    @RequestMapping(value = "/find/module-typeId-shopId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> QueryGoodsByModuleAndTypeIdAndShopId(@RequestParam("module") String module,@RequestParam("typeId") String typeId,@RequestParam("shopId") String shopId,Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        result.put("items",goodsBlService.findGoodsByModuleAndTypeIdAndShopId(module,typeId,shopId,pageable));
        return new ResponseEntity<>(ResultGenerator.genSuccessResult(result),HttpStatus.OK);
    }
}
