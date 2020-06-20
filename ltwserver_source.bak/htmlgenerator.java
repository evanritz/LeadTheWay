package org.evan.LeadTheWay.server;

import java.util.ArrayList;

public class htmlgenerator {
	
	public String gen(ArrayList<client> client_addresses)
	{
		StringBuffer str_buff = new StringBuffer();
		str_buff.append("<!DOCTYPE html>\r\n" + 
				"<html dir=\"ltr\" lang=\"de\"><head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"<title>LTW Dashboard</title><meta name=\"description\" content=\"\"><meta name=\"\" content=\"\"><meta name=\"language\" content=\"de\">\r\n" + 
				"\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"\r\n" + 
				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n" + 
				"<meta name=\"MSSmartTagsPreventParsing\" content=\"TRUE\">\r\n" + 
				"<link rel=\"preload\" href=\"https://demo.saschadiercks.de/startpage/assets/wallpaper/default.svg\" as=\"image\">\r\n" + 
				"\r\n" + 
				"<style>\r\n" + 
				"		html{box-sizing:border-box}*,*:before,*:after{box-sizing:inherit}body{-webkit-font-smoothing:antialiased;-moz-osx-font-smoothing:grayscale}html{font-size:100%;height:100%;overflow-y:auto;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%}body{margin:0;padding:0}img{height:auto;max-width:100%}header,main,footer{display:block}button{background-color:rgba(0,0,0,0);border-width:0;cursor:pointer;font-size:inherit}header{width:100%;z-index:2}a{color:inherit}main{left:0;right:0;margin:1vw;position:relative;z-index:1}footer:after{content:\"\";display:table;clear:both}nav ul{list-style-type:none;margin-top:0;margin-bottom:0;padding-left:0}nav ul:after{content:\"\";display:table;clear:both}nav a{display:block;text-decoration:none}.list-tiles{list-style-type:none;margin-top:0;margin-bottom:0;padding-left:0;margin-left:auto;margin-right:auto}.list-vertical{list-style-type:none;margin-top:0;margin-bottom:0;padding-left:0;padding-bottom:.75vw}.list-vertical__link{display:block;text-decoration:none}.list-vertical__link:hover{text-decoration:underline}.list-horizontal{list-style-type:none;margin-top:0;margin-bottom:0;padding-left:0}.list-horizontal li{display:inline-block}.js .tabbed-content:not(.active){display:none}.backdrop{background-color:rgba(8,34,63,0.6);height:100vh;position:absolute;-webkit-transition:opacity 0s ease;transition:opacity 0s ease;top:0;width:100vw;z-index:-1}.collapse{display:block}.collapse.js-closed .collapse-icon{-webkit-transform:rotate(-45deg);transform:rotate(-45deg)}.collapse.js-closed .collapse-main{max-height:0}.collapse-title{font-size:inherit;font-weight:600;margin:0;padding-top:inherit}.collapse-title .js-collapse-toggle{cursor:pointer;display:block;outline:none;padding-left:0;text-align:left;width:100%}.collapse-icon{display:inline-block;float:right;position:relative;top:-2px;-webkit-transition:-webkit-transform .2s ease;transition:-webkit-transform .2s ease;transition:transform .2s ease;transition:transform .2s ease, -webkit-transform .2s ease}.collapse-main{max-height:100vh;overflow:hidden;-webkit-transition:max-height .5s ease;transition:max-height .5s ease}.modal{display:block;position:fixed;top:0;z-index:2}.modal-overlay{-webkit-transform:translate(-50%, -50%) scale(0);transform:translate(-50%, -50%) scale(0);position:fixed;left:50%;top:50%}.modal-header{font-weight:600;position:relative}.modal-content{overflow-y:auto}.modal-header__close{position:absolute;top:50%;-webkit-transform:translateY(-50%);transform:translateY(-50%);right:0}.modal-list{list-style-type:none;margin-top:0;margin-bottom:0;padding-left:0}.modal-list__item{display:inline-block;width:49%}@supports ((display: -ms-grid) or (display: grid)){.modal-list{display:-ms-grid;display:grid;-ms-grid-columns:50% auto;grid-template-columns:50% auto}.modal-list__item{width:100%}}.modal-list__link{display:block;padding:9px;text-decoration:none}.modal-list__link:hover{background-color:#f5f5f5}.modal-content--qr{text-align:center}.modal-content--qr img{mix-blend-mode:multiply}.notification{-webkit-transition:all .2s;transition:all .2s}.notification.js-hidden{-webkit-transform:translateX(100%);transform:translateX(100%)}.notification.js-visible{right:1vw;-webkit-transform:translateX(0%);transform:translateX(0%)}.overlay{display:block;position:fixed;z-index:2}.overlay.js-hidden{height:0}.overlay-close{float:right}.overlay-title{font-size:1rem;font-weight:600;margin-top:0;padding-top:inherit}.overlay-content{height:100vh;overflow-y:auto;-webkit-transition:all .2s ease;transition:all .2s ease;width:100%}.tile{display:block;position:relative}.tile-image{display:inline-block;max-height:100%;max-width:100%;object-fit:contain}.tile-title{overflow:hidden;white-space:nowrap;text-overflow:ellipsis}#wallpaper{bottom:0;left:0;position:fixed;right:0;top:0}.js-fixed{position:fixed}.js-sticky{position:fixed}#notification{display:block !important}.overlay{display:block !important}body{background-color:#fdfdfd;font-family:-apple-system,sans-serif}#wallpaper{background-size:cover;background-position:center center;-webkit-filter:blur(0.1px);filter:blur(0.1px)}.collapse{border-top:1px solid #ddd}.modal-overlay{-webkit-transform:translate(-50%, -50%) scale(0);transform:translate(-50%, -50%) scale(0);position:fixed;left:50%;top:50%;background-color:#fdfdfd;border-radius:4px;color:#333;box-shadow:0 2px 4px rgba(0,0,0,0.2);max-height:400px;height:auto;max-width:500px;width:90%;-webkit-transition:-webkit-transform .2s ease-in-out;transition:-webkit-transform .2s ease-in-out;transition:transform .2s ease-in-out;transition:transform .2s ease-in-out, -webkit-transform .2s ease-in-out}.js-visible .modal-overlay{-webkit-transform:translate(-50%, -50%) scale(1);transform:translate(-50%, -50%) scale(1);position:fixed;left:50%;top:50%}.modal-header{background-color:rgba(0,0,0,0);border-bottom:2px solid #007acc;color:#333;padding:18px;margin-bottom:9px}.modal-content{padding:9px}.overlay{height:100vh;width:100%}.overlay-content{background-color:#fdfdfd;box-shadow:0 2px 4px rgba(0,0,0,0.2);color:#333}.js-hidden .backdrop{height:0;opacity:0}.js-hidden .overlay-content{-webkit-transform:translateX(100%);transform:translateX(100%)}.js-visible .backdrop{opacity:1}.js-visible .overlay-content{-webkit-transform:translateX(0);transform:translateX(0)}header{background-color:#fdfdfd;box-shadow:0 1px 1px rgba(0,0,0,0.2)}header.js-sticky{top:0}header .collapse{border-width:0}nav li{display:inline-block}nav a{color:#333}nav a:hover,nav a.active{background-color:#007acc;border-radius:2px;color:#fff}.list-tiles{-webkit-box-align:stretch;-ms-flex-align:stretch;align-items:stretch;display:-webkit-box;display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap}.tile-container{padding:.5vw;width:25%}@supports ((display: -ms-grid) or (display: grid)){.list-tiles{display:-ms-grid;display:grid;grid-gap:1vw;-ms-grid-columns:(minmax(256px, 1fr))[auto-fit];grid-template-columns:repeat(auto-fit, minmax(256px, 1fr))}.tile-container{padding:0;width:auto}}.tile-container{display:-webkit-box;display:-ms-flexbox;display:flex;height:156px;position:relative}.tile{background-image:-webkit-linear-gradient(top, rgba(253,253,253,0.9), rgba(245,245,245,0.97));background-image:linear-gradient(to bottom, rgba(253,253,253,0.9), rgba(245,245,245,0.97));background-clip:padding-box;border:1px solid #f5f5f5;box-shadow:0 1px 1px rgba(0,0,0,0.2);border-radius:2px;display:-webkit-box;display:-ms-flexbox;display:flex;font-size:.75rem;position:relative;text-align:center;text-decoration:none;width:100%}.tile:hover{border-color:#ddd;background-image:-webkit-linear-gradient(bottom, rgba(253,253,253,0.9), rgba(245,245,245,0.97));background-image:linear-gradient(to top, rgba(253,253,253,0.9), rgba(245,245,245,0.97));z-index:2}.tile-title{background-color:rgba(245,245,245,0.3);bottom:0;color:#333;left:0;display:block;padding:.5vw;position:absolute;right:0}.tile__button{color:inherit;left:1px;padding:.5vw;position:absolute;top:1px;z-index:2}.tile-image{margin:auto}#bookmarks .overlay-content{max-width:400px;position:fixed;top:0;right:0}#bookmarks ul{list-style-type:none;margin-top:0;margin-bottom:0;padding-left:0}#bookmarks a{font-size:.875rem;padding:2px 0}.notification{background-color:#fdfdfd;box-shadow:0 2px 4px rgba(0,0,0,0.2);color:#333;padding:1vw;right:0;position:fixed;bottom:3vw;z-index:99}footer{background-color:#007acc;color:#fff;font-size:.75rem;padding-left:1vw;padding-right:1vw;width:100%;z-index:2}footer.js-sticky{bottom:0}footer a{color:inherit;display:inline-block;padding-top:9px;padding-bottom:9px}footer .description{float:left}footer .social-profiles{float:right}.js-fx header,.js-fx main,.js-fx footer,.js-fx #wallpaper{-webkit-filter:blur(1px);filter:blur(1px)}@media (max-width: 670px){button{padding:1vw 2vw}header,.overlay-content{padding:2vw 1.5vw}header a{padding:1vw 2vw}.overlay-title{padding-top:1vw;padding-bottom:1vw}header{display:-ms-grid;display:grid;-ms-grid-columns:(1fr)[2];grid-template-columns:repeat(2, 1fr)}#bookmarks-toggle{justify-self:end}#header-nav-toggle{justify-self:start}#header-nav{-ms-grid-column:1;grid-column-start:1;-ms-grid-column-span:2;grid-column-end:span 2;max-height:0;overflow:hidden;-webkit-transition:max-height .5s ease;transition:max-height .5s ease}#header-nav.js-opened{max-height:100vh}#header-nav li{display:block}}@media (min-width: 671px){button{padding:.75vw 1vw}header,.overlay-content{padding:.75vw 1vw}header a{padding:.75vw 1vw}header .collapse-main{overflow:visible}#bookmarks-toggle{float:right}.overlay-title,.collapse a{padding-top:.75vw;padding-bottom:.75vw}.tile-title{opacity:0;-webkit-transition:opacity .2s;transition:opacity .2s}.tile:hover .tile-title{opacity:1}button[data-target*=\"nav\"]{display:none}}body:not(.js) main nav:not(:last-child){margin-bottom:2vw;padding-bottom:2vw;border-bottom:1px dotted #f5f5f5}\r\n" + 
				"	</style>\r\n" + 
				"\r\n" + 
				"<link rel=\"apple-touch-icon\" href=\"https://demo.saschadiercks.de/startpage/apple-touch-icon-foto-228x228-precomposed.png\" sizes=\"228x228\">\r\n" + 
				"<link rel=\"shortcut icon\" href=\"https://imgur.com/LBBTLPu.png\">\r\n" + 
				"</head>\r\n" + 
				"<body class=\"js\">\r\n" + 
				"<iframe name=\"hiddenFrame\" width=\"0\" height=\"0\" border=\"0\" style=\"display: none;\"></iframe>" +
				"\r\n" + 
				"<header id=\"application-header\" class=\"js-sticky\">\r\n" + 
				"<img src=\"https://i.imgur.com/jTCIlZh.jpg\" />\r\n" + 
				"<nav id=\"header-nav\" class=\"collapse tabs\">\r\n" + 
				"<ul class=\"collapse-main tablist\">\r\n" + 
				"<li class=\"tablist__item\">\r\n" + 
				"<a href=\"#tab-1\" class=\"js-tab-trigger active\" data-target=\"tab-1\">Dashboard</a>\r\n" + 
				"</li>\r\n" + 
				"<li class=\"tablist__item\">\r\n" + 
				"<a href=\"#tab-2\" class=\"js-tab-trigger\" data-target=\"tab-2\"></a>\r\n" + 
				"</li>\r\n" + 
				"<li class=\"tablist__item\">\r\n" + 
				"<a href=\"#tab-3\" class=\"js-tab-trigger\" data-target=\"tab-3\"></a>\r\n" + 
				"</li>\r\n" + 
				"<li class=\"tablist__item tablist__item--last-child\">\r\n" + 
				"<a href=\"#tab-4\" class=\"js-tab-trigger\" data-target=\"tab-4\"></a>\r\n" + 
				"</li>\r\n" + 
				"</ul>\r\n" + 
				"</nav>\r\n" + 
				"</header>");
		str_buff.append("\r\n" + 
				"<main id=\"content\" style=\"padding-top: 64px; padding-bottom: 33px;\">\r\n" + 
				"<div id=\"tab-5\" class=\"tabbed-content active\">\r\n" + 
				"<ul class=\"list-tiles\">");
		int count1 = 0;
		for (client client : client_addresses) {
			str_buff.append("<li class=\"tile-container\">\r\n" + 
					"<a href=\"\" rel=\"noopener\" class=\"tile js-modal-toggle\" data-target=\"linksasmodal" + count1 + "\">\r\n" + 
					"<img src=\"\" alt=\"" + client.name + "\" class=\"tile-image\">\r\n" + 
					"<span class=\"tile-title\">" + client.hostname + "</span>\r\n" + 
					"</a>\r\n" + 
					"</li>");
			count1++;
		}
		str_buff.append("</ul>\r\n" + 
				"</div>\r\n" + 
				"</main>");
		int count = 0;
		for (client client : client_addresses) {
			str_buff.append("<div id=\"assets/qr-codes/github-project.png\" class=\"modal js-hidden\">\r\n" + 
					"<div class=\"modal-overlay\">\r\n" + 
					"<div class=\"modal-header\">\r\n" + 
					"</div>\r\n" + 
					"<div class=\"modal-content modal-content--qr\">\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"<div id=\"linksasmodal" + count + "\" class=\"modal js-hidden\">\r\n" + 
					"<div class=\"modal-overlay\">\r\n" + 
					"<div class=\"modal-header\">\r\n" + client.name +  
					"<button class=\"modal-header__close js-modal-toggle\" data-target=\"linksasmodal" + count + "\">×</button>\r\n" + 
					"</div>\r\n" + 
					"<div class=\"modal-content\">\r\n" + 
					"<ul class=\"modal-list\">\r\n" + 
					"<li class=\"modal-list__item\">\r\n" + 
					"<a href=\"\" target=\"_self\" class=\"modal-list__link\">Status:</a>\r\n" + 
					"</li>\r\n" + 
					"<li class=\"modal-list__item\">\r\n" + 
					"<a href=\"\" target=\"_self\" class=\"modal-list__link\">" + client.status + "</a>\r\n" + 
					"</li>\r\n" + 
					"<li class=\"modal-list__item\">\r\n" + 
					"<a href=\"\" target=\"_self\" class=\"modal-list__link\">Requests:</a>\r\n" + 
					"</li>\r\n" + 
					"<li class=\"modal-list__item\">\r\n" + 
					"<a href=\"\" target=\"_self\" class=\"modal-list__link\">" + client.requests + "</a>\r\n" +
					"</li>\r\n" +
					"<li class=\"modal-list__item\">\r\n" + 
					"<a href=\"\" target=\"_self\" class=\"modal-list__link\">Online:</a>\r\n" + 
					"</li>\r\n" + 
					"<li class=\"modal-list__item\">\r\n" + 
					"<a href=\"\" target=\"_self\" class=\"modal-list__link\">" + client.online + "</a>\r\n" + 
					"</li>\r\n" +
					"<li class=\"modal-list__item\">\r\n" + 
					"<form action=\"/name\" method=\"post\" target=\"hiddenFrame\" onsubmit=\"setTimeout(function () { window.location.reload(); }, 10)\" class=\"modal-list__link\"> Custom Name?: <input type=\"text\" name=\"name\"/> <input type=\"hidden\" name=\"client_hostname\" value=\"" + client.hostname + "\"/> <input type=\"submit\" value=\"Submit\"> </form> \r\n" + 
					"</li>\r\n" +
					"</li>\r\n" + 
					"</ul>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"<div class=\"backdrop js-modal-toggle\" data-target=\"linksasmodal" + count + "\"></div>\r\n" + 
					"</div>");
			count++;
		}
		
		str_buff.append("<footer id=\"application-footer\" class=\"js-sticky\">\r\n" + 
				"<div class=\"description\"><a href=\"\" target=\"_self\">Something will go here</a></div>\r\n" + 
				"<div class=\"social-profiles\">\r\n" + 
				"<ul class=\"list-horizontal\">\r\n" + 
				"<li><a href=\"https://leadtheway.xyz/\" target=\"_self\">website</a></li>\r\n" + 
				"<li><a href=\"https://github.com/leadtheway\" target=\"_self\">github</a></li>\r\n" + 
				"</ul>\r\n" + 
				"</div>\r\n" + 
				"</footer>\r\n" + 
				"<div id=\"wallpaper\" style=\"background-image:url('assets/wallpaper/default.svg')\"></div>\r\n" + 
				"\r\n" + 
				"<script>\r\n" + 
				"		document.addEventListener(\"DOMContentLoaded\",function(){function e(e,t){e.classList.add(t)}function t(e,t){e.classList.remove(t)}function n(e,t){window.scrollTo(e,t)}function o(t,n,o){var i=document.getElementById(n),s=document.getElementById(t),a=s.clientHeight+\"px\";e(s,\"js-sticky\"),i.style.setProperty(o,a)}function s(e){var t=document.getElementsByClassName(e);for(i=0;i<t.length;i++)t[i].onclick=function(e){a(this.getAttribute(\"data-target\"),e)}}function a(n,o){var i=document.getElementById(n),s=document.getElementsByTagName(\"body\")[0];i.classList.contains(\"js-visible\")?(e(i,\"js-hidden\"),t(i,\"js-visible\"),t(s,\"js-fx\")):(t(i,\"js-hidden\"),e(i,\"js-visible\"),e(s,\"js-fx\")),c(\"content\"),o.preventDefault()}function l(n,o){var i=document.getElementById(n);i.classList.contains(\"js-opened\")?(e(i,\"js-closed\"),t(i,\"js-opened\")):(t(i,\"js-closed\"),e(i,\"js-opened\")),o.preventDefault()}function c(o){elementToFix=document.getElementById(o),scrollY=window.pageYOffset,elementToFix.classList.contains(\"js-fixed\")?(t(elementToFix,\"js-fixed\"),elementToFix.style.top=\"\",n(0,scrollYMem)):(e(elementToFix,\"js-fixed\"),elementToFix.style.top=\"-\"+scrollY+\"px\",scrollYMem=scrollY),console.log(scrollYMem)}function d(){o(\"application-header\",\"content\",\"padding-top\"),o(\"application-footer\",\"content\",\"padding-bottom\")}document.addEventListener(\"keydown\",function(){var n=document.getElementById(\"notification\");e(n,\"js-visible\"),t(n,\"js-hidden\")}),document.addEventListener(\"keyup\",function(){var n=document.getElementById(\"notification\");e(n,\"js-hidden\"),t(n,\"js-visible\")}),updateLocalStorageOnTabSwitch=!0;var g=document.getElementsByClassName(\"js-tab-trigger\"),r=document.getElementsByClassName(\"tabbed-content\");g.length!==r.length&&console.log(\"count of tabs and tabbed-contend isn't consistent\");var m=function(e){markTabTrigger=document.getElementsByClassName(\"js-tab-trigger\")[e].classList.add(\"active\"),unhideSelectedContent=document.getElementsByClassName(\"tabbed-content\")[e].classList.add(\"active\"),!1===updateLocalStorageOnTabSwitch?console.log(\"localStorage not updated\"):(localStorage.setItem(\"tabbedContentId\",e),console.log(\"localStorage ID is: \"+e))},u=function(){for(i=0;i<r.length;i++)t(g[i],\"active\"),t(r[i],\"active\")},f=localStorage.getItem(\"tabbedContentId\");for(null!==f&&g.length>=f?m(f):(console.log(\"localStorage is empty or stored Id is no longer present - setting default\"),m(0)),i=0;i<g.length;i++)!function(e){g[i].onclick=function(t){return!0===t.altKey?updateLocalStorageOnTabSwitch=!1:updateLocalStorageOnTabSwitch=!0,u(),m(e,updateLocalStorageOnTabSwitch),!1}}(i);!function(){e(document.getElementsByTagName(\"body\")[0],\"js\")}(),d(),window.onresize=d,function(e){var t=document.getElementsByClassName(e);for(i=0;i<t.length;i++)t[i].onclick=function(e){l(this.getAttribute(\"data-target\"),e)}}(\"js-collapse-toggle\"),s(\"js-overlay-toggle\"),s(\"js-modal-toggle\")});	</script>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body></html>");
		
		return str_buff.toString();
		
	}
	
	
}
