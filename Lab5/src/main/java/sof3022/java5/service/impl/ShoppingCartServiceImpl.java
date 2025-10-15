package sof3022.java5.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import sof3022.java5.data.DB;
import sof3022.java5.entity.Item;
import sof3022.java5.service.ShoppingCartService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService{
    Map<Integer, Item> map = new HashMap<>();
    @Override
    public Item add(Integer id) {
        /**
         * TODO: Xử lý logic
         */


        // Kiểm tra xem item mới thêm đã có trong giỏ hàng chưa
        Item item = map.get(id);

        // Nếu chưa có
        if(item == null){
            // Lấy item mẫu từ database
            Item sourceItem = DB.items.get(id);
            item = new Item(sourceItem.getId(), sourceItem.getName(), sourceItem.getPrice(), 1);
            map.put(id, item);
        // Nếu đã có
        }else{
            // Tăng số lượng của item lên thêm 1 đơn vị
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        item.setQty(qty);
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(Item :: getQty)
                .sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
}
