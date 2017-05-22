# Tablayout
基于鸿洋的Autolayout和RecyclerView实现的tablayout

关联了fragment和viewpager

# 效果图

<img src="https://github.com/CorruptWood/Tablayout/blob/master/tablayout.gif"/>

# 引入

在项目的build.gradle中添加：

    	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
添加依赖关系：
 
     dependencies {
	        compile 'com.github.CorruptWood:Tablayout:1.1.3'
	 }
	 
	 
库中使用的是recylcerView：25.0.2，如果不想使用。添加以下依赖：
  
      dependencies {
      
	     compile ('com.github.CorruptWood:Tablayout:1.1.3',{
		exclude group: 'com.android.support'
	    })
        ｝
      

如果你依赖了鸿洋的autolayout,不想使用库中的autolayout,添加以下依赖：
 
      dependencies {
	     compile ('com.github.CorruptWood:Tablayout:1.1.3',{
	        exclude group: 'com.zhy',module:'autolayout'
		exclude group: 'com.android.support'
	    })
        ｝
       


# 用法

####  注意：tabResId必须赋值，否则会报错。tabResId为单个条目的布局,通过（app:tabResId="@layout/tab_view_two"）赋值，目前支持（TextView）标题、（TextView）副标题、（ImageView）图片、（View）线,具体布局样式根据自己的需求设置。

#### 如果需要改变item的字体大小，一定记住，定义的item的xml中标题不要设置字体大小的属性（android:textSize）,使用 subtitleUnSelectSize、subtitleSelectSize等属性设置对应的字体大小

#### 如果你需要对每个item的颜色进行单独设置，设置useEntityColor属性为true,在TabEntity中设置对应控件的颜色，line的未选中颜色默认为透明

####  四个控件对应的ID必须跟下面的ID保持一致，切命名的时候使用：android:id=@id/.....
	
	  <item name="tablayout_title" type="id" />
    	  <item name="tablayout_subtitle" type="id" />
	  <item name="tablayout_image" type="id" />
	  <item name="tablayout_line" type="id" />
	  

### 第一步：
在你的项目的AndroidManifest中注明你的设计稿的尺寸。


    <meta-data android:name="design_width" android:value="768"/>
    <meta-data android:name="design_height" android:value="1280"/>
   
  
### 第二步：
在xml中使用：

	<com.zdm.tablayout.TabLayout
        app:isScroll="true"
        android:id="@+id/tabLayout2"
        android:layout_width="match_parent"
        android:layout_height="100px"
        android:layout_marginTop="10px"
        android:background="#fff"
        app:lineSelectColor="#ff6633"
        app:tabResId="@layout/tab_view_two" />
	
	
tab_view_two的布局：

	  <TextView
		android:layout_weight="1"
		android:id="@id/tablayout_title"
		android:layout_width="180px"
		android:layout_height="match_parent"
		android:gravity="center"/>

       <ImageView
		android:id="@id/tablayout_line"
		android:layout_width="180px"
		android:layout_height="2px"/>
	

### 第三步：
创建TabEntity集合，添加集合数据

      List<Fragment> fragmentList = new ArrayList<>();
        List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.title[x], Constants.selectIcons[x],
                    Constants.unSelectIcons[x]));
            fragmentList.add(TabFragment.getTabFragment(x, 1));
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
        <!--是否显示线-->
        <attr name="lineSelectColor" format="color"/>
        <attr name="lineUnSelectColor" format="color"/>
        <attr name="titleSelectColor" format="color"/>
        <attr name="titleUnSelectColor" format="color"/>
        <attr name="subtitleSelectColor" format="color"/>
        <attr name="subtitleUnSelectColor" format="color"/>
        <attr name="titleSelectSize" format="dimension"/>
        <attr name="titleUnSelectSize" format="dimension"/>
        <attr name="subtitleSelectSize" format="dimension"/>
        <attr name="subtitleUnSelectSize" format="dimension"/>
        <attr name="useEntityColor" format="boolean"/>
	
	
## tablayout的接口：


     public interface OnItemBindViewDataListener {
        /**
         * 会在tablayout的切换按钮逻辑代码之后调用次接口，不会覆盖tablayout的逻辑代码
         * @param holder
         * @param tabEntity   当前item的实体类
         * @param selectPosition  当前选中的item 此索引为选中的索引
         * @param position    当前的索引
         */
        void OnItemBindViewDataListener(TabRecylerAdapter.ViewHolder holder,TabEntity tabEntity, int selectPosition, int position);
    }
    

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
