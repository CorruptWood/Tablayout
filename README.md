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

####  注意：tabCount和tabResId必须赋值，否则会报错。tabResId为单个条目的布局，目前支持文字、图片、线,具体布局样式根据自己的需求设置。
####  文字、图片、线的id必须使用  


	textView = (TextView) itemView.findViewById(R.id.text);//文字
       	image = (ImageView) itemView.findViewById(R.id.image);//图片
        line = itemView.findViewById(R.id.line1);//线
	
	
	
在xml中使用：

	<com.zdm.tablayout.TabLayout
        app:isScroll="true"
        android:id="@+id/tabLayout2"
        android:layout_width="match_parent"
        android:layout_height="100px"
        android:layout_marginTop="10px"
        android:background="#fff"
        app:tabCount="8"
        app:isShowLine="true"
        app:lineSelectColor="#ff6633"
        app:tabResId="@layout/tab_view_two" />
	

### 第三步：
创建TabEntity集合，添加集合数据

     List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.title[x], Constants.selectIcons[x],
                    Constants.unSelectIcons[x], Color.parseColor("#1296db"),
                    Color.parseColor("#333333")));
            fragmentList.add(TabFragment.getTabFragment(x,1));
        }
      
        
### 第四步：
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
	
	
## tablayout的属性：

	 <!--单个tab的布局样式-->
        <attr name="tabResId" format="reference"/>
        <!--tabLayout 是否可以滑动 默认false-->
        <attr name="isScroll" format="boolean"/>
        <!--tab的数量  如果不可以滑动 数量不建议超过5个-->
        <attr name="tabCount" format="integer"/>
        <!--是否显示线-->
        <attr name="isShowLine" format="boolean"/>
        <attr name="lineSelectColor" format="color"/>
        <attr name="lineUnSelectColor" format="color"/>
	
	
## tablayout的接口：

    /**
     * 会覆盖TabLayout的方法 需要自己实现切换效果
     */
    public interface OnItemClickListener {
        void OnItemClickListener(View v, int position);
    }

    /**
     * 实现ViewPager的OnPageChangeListener 会覆盖TabLayout的方法
     */
    public interface OnPageChangeListener{

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        public void onPageSelected(int position);

        public void onPageScrollStateChanged(int state);
    }

    /**
     * 实现ViewPager的OnPageChangeListener中的onPageSelected   不会覆盖TabLayout的方法
     */
    public interface OnPageSelectedListener{

        public void onPageSelected(int position);
    }
