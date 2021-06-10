public class Main {

    public static void main(String[] args) {

        TreeNode<Category> root = new TreeNode<Category>(new Category(0,0,"root"));
        //добавление
        TreeNode<Category> node0 = root.addChild(new Category(1,0,"node0"));
        TreeNode<Category> node1 = root.addChild(new Category(2,0,"node1"));
        node0.addChild(new Category(1,0,"node01"));

        //отображение данных полей объектов
        System.out.println(root.getData());

        //установка категории верхнего уровня (parent-категория)
        node0.setParent(node1);
        System.out.println(node0.getParent().getData());

        //удаление узла без потомков
        node0.removeChildNode();
        System.out.println(node0.isLeaf());

        System.out.println(node1.removeChildNode());

        //обновление данных полей объектов
        node0.setData(new Category(4, 7, "setNode0"));
        System.out.println(node0.getData());

        node1.getData().setName("setNode1Name");
        System.out.println(node1.getData());

    }
}
