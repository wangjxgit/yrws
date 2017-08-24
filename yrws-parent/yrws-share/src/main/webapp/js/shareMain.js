/*$(".swiper-slide").on("click",".otherShare",function (){
	self.location='./shareMain.html';
	// alert(1);
})*/
		var mySwiper = new Swiper ('.swiper-container', {
			direction: 'horizontal',
			pagination: '.pagination',
			paginationType : 'custom',
		});
		var p=document.getElementsByClassName('myPagination');
		var slide=document.getElementsByClassName('swiper-slide');
		var wrapper=document.getElementsByClassName('swiper-wrapper')[0];
		for(var i=0;i<p.length;i++){
			p[i].index=i;
			p[i].addEventListener('touchstart',function(e){
				mySwiper.slideTo(this.index,300,false);
				if(this.index==0){
					p[0].classList.add('onShow');
					p[1].classList.remove('onShow');
				}else{
					p[0].classList.remove('onShow');
					p[1].classList.add('onShow');
				}
			})
		}
		var body=document.getElementsByTagName('body')[0];
		var start;
		var end;
		wrapper.addEventListener('touchend',function(e){
			for(var i=0;i<p.length;i++){
				p[i].classList.remove('onShow');
			}
			var timr=setTimeout(function(){
				input=wrapper.style.transform;
				if(!input){
					input=0;
				}else{
					input=input.match(/\((\S*)/)[1];
					input=input.match(/^.*?p/);
					input=input[0].slice(0,-1);
					input=Math.abs(input);
					input=Math.round(input/window.screen.width);
				}
				p[input].classList.add('onShow');
				clearTimeout(timr);
			})
		})
		
