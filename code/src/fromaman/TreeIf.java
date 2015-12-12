package fromaman;


import java.io.IOException;
import java.util.List;

public interface TreeIf {

	void addChild(String data);
	void addChild(Tree child);
	void addChildAt(int index, Tree child);
	
	
	void removeChildAt(int index);
	void removeAllChildren();

	int getNumOfChildren();
	void traverse() ;
	
	String getData();
	void setData(String data);
	Tree getChildAt(int index);
	List<Tree> getChildren();
	void setChildren(List<Tree> children);	
	
	void serialize(String fileName) throws IOException;
	Tree deserialize(String fileName)  throws IOException;
	
}
