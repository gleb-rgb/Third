package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ProductPack pack1 = new ProductPack("Коробка", 1);
            ProductPack pack2 = new ProductPack("Банка", 2);
            ProductPack pack3 = new ProductPack("Пакет", 0.5);
            System.out.println(pack1);
            System.out.println(pack2);
            System.out.println(pack3);
            System.out.println();

            Product product1 = new Product("Мороженное", "Мороженное 'Золотой стандарт'");
            Product product2 = new Product("Сгущенка", "Сгущенка 'Любинская'");
            Product product3 = new Product("Пельмени", "Пельмени 'Мишки'");
            System.out.println(product1);
            System.out.println(product2);
            System.out.println(product3);
            System.out.println();


            WeightedProduct weightedProduct = new WeightedProduct("Мороженное", "Мороженное 'Золотой стандарт'", 50);
            PackagedWeight packagedWeight = new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", pack1, weightedProduct.getWeightProduct());
            System.out.println("Масса нетто весового товара: " + packagedWeight.getWeightsNetto());
            System.out.println("Масса брутто весового товара: " + packagedWeight.getWeightBrutto());
            System.out.println();

            PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 10, 4, pack1);
            System.out.println("Масса нетто штучного товара: " + packagedPieceProduct.getWeightNetto());
            System.out.println("Масса брутто штучного товара: " + packagedPieceProduct.getWeightBrutto());

            List<PackagedWeight> goodsList = List.of(
                    new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", pack1, 5),
                    new PackagedWeight("Сгущенка", "Сгущенка 'Любинская'", pack2, 3)
            );

            GoodsBatch batch = new GoodsBatch("Партия товаров", goodsList);
            System.out.println(batch);

            Filter filter = new BeginStringFilter("Мороженное");
            long count = GoodsService.countByFilter(batch, filter);
            System.out.println("Количество товаров, удовлетворяющих фильтру: " + count);

            Filter filter1 = new EndsWithStringFilter("Сгущенка 'Любинская'");
            long count1 = GoodsService.countByFilter(batch, filter1);
            System.out.println("Количество товаров, удовлетворяющих фильтру: " + count1);

            Filter filter2 = new ContainsStringFilter("Золотой");
            long count2 = GoodsService.countByFilter(batch, filter2);
            System.out.println("Количество товаров, удовлетворяющих фильтру: " + count2);

        }catch (IllegalArgumentException e){
                System.out.println("Введены некорректные данные!");
        }
    }
}
