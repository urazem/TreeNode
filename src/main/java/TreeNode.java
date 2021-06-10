import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {

    T data;
    TreeNode<T> parent;
    List<TreeNode<T>> children;


    public TreeNode() {}

    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<TreeNode<T>>();
    }

    public TreeNode(T data, TreeNode<T> parent) {
        // new node with a given parent
        this.children = new LinkedList<>();
        this.data = data;
        this.parent = parent;
        parent.addChild(this);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public TreeNode<T> findChild(T item){
        for (TreeNode<T> child : this.children) {
            if(child.getData().equals(item)){
                return child;
            }
        }
        return null;
    }
    public TreeNode<T> findChild(TreeNode<T> item){
        for (TreeNode<T> child : this.children) {
            if(child.equals(item)){
                return child;
            }
        }
        return null;
    }

    public int getChildrenCount(){
        return this.children.size();
    }

    public List<T> getChildrenData() {
        List<T> arrayChild = new ArrayList<>();
        for (TreeNode<T> child:children) {
            arrayChild.add(child.getData());
        }
        return arrayChild;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    //Добавление объектов
    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }
    public void addChild(TreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }
    public boolean addChild(LinkedList<TreeNode<T>> listChild) {
        for (TreeNode<T> child:listChild) {
            addChild(child);
        }
        return true;
    }
    //удаление узла
    public boolean removeChildNode(){
        List<TreeNode<T>> list = this.getChildren();

        if(list.isEmpty()){
            TreeNode<T> item = this.getParent();
            item.getChildren().remove(this);
            return true;
        }
        else{
            System.out.println("Узел имеет дочерние элементы!");
            return false;
        }
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return (this.children.size() == 0);
    }

    public void removeParent() {
        this.parent = null;
    }
}
