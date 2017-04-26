# Tablayout
基于鸿洋的Autolayout和RecyclerView实现的tablayout

关联了fragment和viewpager

# 效果图

<img src="https://github.com/CorruptWood/Tablayout/blob/master/tablayout.gif"/>

# 引入

在项目的build.gradle中添加：

    	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 添加依赖关系：
 
     dependencies {
	        compile 'com.github.CorruptWood:Tablayout:1.0.0'
	 }
   
# 用法

### 第一步：
在你的项目的AndroidManifest中注明你的设计稿的尺寸。

    <meta-data android:name="design_width" android:value="768"/>
    <meta-data android:name="design_height" android:value="1280"/>
  

### 第二步：
创建TabEntity集合，添加集合数据

     List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.title[x], Constants.selectIcons[x],
                    Constants.unSelectIcons[x], Color.parseColor("#1296db"),
                    Color.parseColor("#333333")));
            fragmentList.add(TabFragment.getTabFragment(x,1));
        }
      
        
### 第二步：
设置数据，3种方式：

##### ① 不关联fragment和Viewpager 自己实现OnItemClickListener

      tabLayout1.bindViewData(list);
      tabLayout1.setOnItemClickListener(new TabInterface.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {
                
            }
        });

##### ② 关联fragment不关联Viewpager 
      
       tabLayout1.bindViewData(list,fragmentList,R.id.container);

##### ③ 关联fragment和Viewpager 

       tabLayout2.bindViewData(list,viewPager,fragmentList);
       
##### ④ 设置默认选中

	tabLayout1.defaultSelected(0);
	
	如果当前tablayout，可以滑动，也可以设置滑动的偏移量，默认偏移量为50

	tabLayout1.defaultSelected(0，60);
