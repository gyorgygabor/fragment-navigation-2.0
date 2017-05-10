# Fragment navigator

Fragment navigator is a simple way to navigate between fragments.

#### Features
- The transaction logic is in one place.
- Handles the transaction exception, when the application is in the background.
- Easy to use and to pass a custom object to the Fragment(See: FragmentC and FragmentD).
- The BaseFragmentActivity handles the onBackPressed event. When you want to handle the onBackPressed event inside your Fragment, your Fragment just need to override the OnBackPressed method and write there your navigation code. Note that it has to return true.
- If you have a navigation drawer in your Activity, after the navigation, the drawer will close automatically if you implement the OnCloseDrawer interface in your Activity. In the *onCloseDrawer()* method is coming your drawer`s close implementation.
- If you do not like the navigation implementation(StandardFragmentNavigationStrategy), you can write your own FragmentNavigation behavior.

#### Implementation steps
1. Extend your *Activity* the *FragmentActivity* class.
2. Override the getFragmentContainerID method and make it to return your fragment container layout id, which is placed in your activity`s xml.
3. Extend your Fragments the *BaseFragment* class.

Now you can navigate with the *getNavigator().navigateTo()* method. This method is accessible from your Activity and Fragments as well.
You can pass to the *getNavigator().navigateTo()* method  your fragment instance or class(new Fragment1(), Fragment1.class), bundle and animations.



You can try it out with the above example or add it to your module level gradle file:

```gradle
compile 'com.gabor.fragment-navigation:app:1.5.0'
```