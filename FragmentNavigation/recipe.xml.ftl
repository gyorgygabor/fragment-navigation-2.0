<?xml version="1.0"?>
<recipe>

    <instantiate from="src/app_package/classes/BaseActivity.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/BaseActivity.java" />

    <instantiate from="src/app_package/classes/BaseFragment.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/BaseFragment.java" />

    <instantiate from="src/app_package/classes/BaseFragmentActivity.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/BaseFragmentActivity.java" />

    <instantiate from="src/app_package/classes/BaseFragmentNavigationStrategy.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/BaseFragmentNavigationStrategy.java" />

    <instantiate from="src/app_package/classes/BaseNavigationFacade.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/BaseNavigationFacade.java" />

    <instantiate from="src/app_package/classes/EmptyNavigationFacade.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/EmptyNavigationFacade.java" />

    <instantiate from="src/app_package/classes/Interfaces.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/Interfaces.java" />

    <instantiate from="src/app_package/classes/NavigationFacade.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/NavigationFacade.java" />
	  
	      <instantiate from="src/app_package/classes/StandardFragmentNavigationStrategy.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/navigation/StandardFragmentNavigationStrategy.java" />

</recipe>
