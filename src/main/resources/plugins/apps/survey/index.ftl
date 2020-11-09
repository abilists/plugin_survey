<#import "/apps/layout/plugins/abilistsPluginsLayout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<style>
.large-button {
    margin: 10px;
	padding: 7%;
	width: 100%;
    font-size: x-large;
}

</style>

<div class="row">
<div class="col-sm-12">
	<div class="caption mittle-size-title middle-works-bg">
		<h5><b>서베이</b></h5>
	</div>
	<div class="item-box" style="overflow: hidden;">

	<div class="item-box">
		This is a sample plugin.
	</div>

<#include "/apps/common/abilistsPluginsLoadJs.ftl"/>

</@layout.myLayout>