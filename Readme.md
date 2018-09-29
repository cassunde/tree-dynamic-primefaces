# tree-dynamic-primefaces

This project show how to create dynamically nodes in a Tree or TreeTable component.

**Thecnnologies**

- JSF / Primefaces
- CDI


**Goal**

With complex business rules and several data to show in page web, an best practices is must sends this data on demand.

**How**

*1)* Started the list of Children with empty element.

```

new DefaultTreeNode(objectActual, treeFather)
			 method	.setChildren( Arrays.asList( new DefaultTreeNode() ) );
				
```


this implementation force the create node in front-end

*2)* Set event expand in component and set the component that will be updated after listener

```
<p:ajax event="expand" update="node" listener="#{treeBean.expand}" />
```

*3)* for end we let's call an method to create new nodes:

```

public void expand(NodeExpandEvent expand) {

		//remove sigle node previously created 
		expand.getTreeNode().getChildren().clear();
		
		for(int i = 0; i <= 10; i++ ) {
			
			Sector sectorActual = new Sector("Sector "+i + " - Child of "+expand.getTreeNode().getData(),"LocalExample");			
			new DefaultTreeNode(sectorActual, expand.getTreeNode())
				.setChildren( Arrays.asList( new CheckboxTreeNode() ) );
		}
	}
	

``` 
