//Global var to avoid any conflicts
var CRUMINA = {};

(function ($) {
    //������ȫ��õ�Bootstrapģ�壺http://www.bootstrapmb.com
	// USE STRICT
	"use strict";

	//----------------------------------------------------/
	// Predefined Variables
	//----------------------------------------------------/
	var $window = $(window),
		$document = $(document),
		$body = $('body'),
        $sidebar = $('.fixed-sidebar'),
		$preloader = $('#hellopreloader');

	/* -----------------------
	 * Preloader
	 * --------------------- */

	CRUMINA.preloader = function () {
		$window.scrollTop(0);
		setTimeout(function () {
			$preloader.fadeOut(800);
		}, 500);
		return false;
	};

	//Scroll to top.
        jQuery('.back-to-top').on('click', function () {
            $('html,body').animate({
                scrollTop: 0
            }, 1200);
            return false;
        });


    /* -----------------------
    * Input Number Quantity
   	* --------------------- */

	$(document).on("click",".quantity-plus",function(){
		var val = parseInt($(this).prev('input').val());
		$(this).prev('input').val(val + 1).change();
		return false;
	});

	$(document).on("click",".quantity-minus",function(){
		var val = parseInt($(this).next('input').val());
		if (val !== 1) {
			$(this).next('input').val(val - 1).change();
		}
		return false;
	});


	/* -----------------------------
	 Custom input type="number"
	 https://bootsnipp.com/snippets/featured/bootstrap-number-spinner-on-click-hold
	 * ---------------------------*/

	$(function () {
		var action;
		$(document).on("touchstart mousedown",".number-spinner button",function(){
			var btn = $(this);
			var input = btn.closest('.number-spinner').find('input');
			btn.closest('.number-spinner').find('button').prop("disabled", false);

			if (btn.attr('data-dir') == 'up') {
				action = setInterval(function () {
					if (input.attr('max') == undefined || parseInt(input.val()) < parseInt(input.attr('max'))) {
						input.val(parseInt(input.val()) + 1);
					} else {
						btn.prop("disabled", true);
						clearInterval(action);
					}
				}, 50);
			} else {
				action = setInterval(function () {
					if (input.attr('min') == undefined || parseInt(input.val()) > parseInt(input.attr('min'))) {
						input.val(parseInt(input.val()) - 1);
					} else {
						btn.prop("disabled", true);
						clearInterval(action);
					}
				}, 50);
			}
		});
		$(document).on("touchend mouseup",".number-spinner button",function() {
			clearInterval(action);
		});
	});

	/* -----------------------------
	 * Toggle functions
	 * ---------------------------*/

    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        var target = $(e.target).attr("href"); // activated tab
        if('#events' === target){
            $('.fc-state-active').click();
        }
    });

	// Toggle aside panels
	$(".js-sidebar-open").on('click', function () {
		var mobileWidthApp = $('body').outerWidth();
		if(mobileWidthApp <= 560) {
			$(this).closest('body').find('.popup-chat-responsive').removeClass('open-chat');
		}

        $(this).toggleClass('active');
        $(this).closest($sidebar).toggleClass('open');
        return false;
    });

	// Close on "Esc" click
    $window.keydown(function (eventObject) {
        if (eventObject.which == 27 && $sidebar.is(':visible')) {
            $sidebar.removeClass('open');
        }
    });

    // Close on click outside elements.
    $document.on('click', function (event) {
        if (!$(event.target).closest($sidebar).length && $sidebar.is(':visible')) {
            $sidebar.removeClass('open');
        }
    });

    // Toggle inline popups

    var $popup = $('.window-popup');

    $(".js-open-popup").on('click', function (event) {
        var target_popup = $(this).data('popup-target');
        var current_popup = $popup.filter(target_popup);
        var offset = $(this).offset();
        current_popup.addClass('open');
        current_popup.css('top', (offset.top - (current_popup.innerHeight() / 2)));
        $body.addClass('overlay-enable');
        return false;
    });

    // Close on "Esc" click
    $window.keydown(function (eventObject) {
        if (eventObject.which == 27) {
            $popup.removeClass('open');
            $body.removeClass('overlay-enable');
			$('.profile-menu').removeClass('expanded-menu');
			$('.popup-chat-responsive').removeClass('open-chat');
			$('.profile-settings-responsive').removeClass('open');
			$('.header-menu').removeClass('open');
			$('.js-sidebar-open').removeClass('active');
        }
    });

    // Close on click outside elements.
    $document.on('click', function (event) {
        if (!$(event.target).closest($popup).length) {
            $popup.removeClass('open');
            $body.removeClass('overlay-enable');
			$('.profile-menu').removeClass('expanded-menu');
			$('.header-menu').removeClass('open');
			$('.profile-settings-responsive').removeClass('open');
        }
    });

    // Close active tab on second click.
    $('[data-toggle=tab]').on('click', function(){
		/*$body.toggleClass('body--fixed');*/
        if ($(this).hasClass('active') && $(this).closest('ul').hasClass('mobile-app-tabs')){
            $($(this).attr("href")).toggleClass('active');
            $(this).removeClass('active');
            return false;
        }
    });


    // Close on "X" click
    $(".js-close-popup").on('click', function () {
        $(this).closest($popup).removeClass('open');
        $body.removeClass('overlay-enable');
        return false
    });

	$(".profile-settings-open").on('click', function () {
		$('.profile-settings-responsive').toggleClass('open');
		return false
	});

	$(".js-expanded-menu").on('click', function () {
		$('.header-menu').toggleClass('expanded-menu');
		return false
	});

	$(".js-chat-open").on('click', function () {
		$('.popup-chat-responsive').toggleClass('open-chat');
		return false
	});
    $(".js-chat-close").on('click', function () {
        $('.popup-chat-responsive').removeClass('open-chat');
        return false
    });

	$(".js-open-responsive-menu").on('click', function () {
		$('.header-menu').toggleClass('open');
		return false
	});

	$(".js-close-responsive-menu").on('click', function () {
		$('.header-menu').removeClass('open');
		return false
	});


	/* -----------------------------
		 * Scrollmagic scenes animation
	* ---------------------------*/

	CRUMINA.CallToActionAnimation = function () {
		var controller = new ScrollMagic.Controller();

		new ScrollMagic.Scene({triggerElement: ".call-to-action-animation"})
			.setVelocity(".first-img", {opacity: 1, bottom: "0", scale: "1"}, 1200)
			.triggerHook(1)
			.addTo(controller);

		new ScrollMagic.Scene({triggerElement: ".call-to-action-animation"})
			.setVelocity(".second-img", {opacity: 1, bottom: "50%", right: "40%"}, 1500)
			.triggerHook(1)
			.addTo(controller);
	};

	CRUMINA.ImgScaleAnimation = function () {
		var controller = new ScrollMagic.Controller();

		new ScrollMagic.Scene({triggerElement: ".img-scale-animation"})
			.setVelocity(".main-img", {opacity: 1, scale: "1"}, 200)
			.triggerHook(0.3)
			.addTo(controller);

		new ScrollMagic.Scene({triggerElement: ".img-scale-animation"})
			.setVelocity(".first-img1", {opacity: 1, scale: "1"}, 1200)
			.triggerHook(0.8)
			.addTo(controller);

		new ScrollMagic.Scene({triggerElement: ".img-scale-animation"})
			.setVelocity(".second-img1", {opacity: 1, scale: "1"}, 1200)
			.triggerHook(1.1)
			.addTo(controller);

		new ScrollMagic.Scene({triggerElement: ".img-scale-animation"})
			.setVelocity(".third-img1", {opacity: 1, scale: "1"}, 1200)
			.triggerHook(1.4)
			.addTo(controller);
	};

	CRUMINA.SubscribeAnimation = function () {
		var controller = new ScrollMagic.Controller();

		new ScrollMagic.Scene({triggerElement: ".subscribe-animation"})
			.setVelocity(".plane", {opacity: 1, bottom: "auto", top: "-20", left: "50%", scale: "1"}, 1200)
			.triggerHook(1)
			.addTo(controller);

	};

	CRUMINA.PlanerAnimation = function () {
		var controller = new ScrollMagic.Controller();

		new ScrollMagic.Scene({triggerElement: ".planer-animation"})
			.setVelocity(".planer", {opacity: 1, left: "80%", scale: "1"}, 2000)
			.triggerHook(0.1)
			.addTo(controller);

	};

	CRUMINA.ContactAnimationAnimation = function () {
		var controller = new ScrollMagic.Controller();

		new ScrollMagic.Scene({triggerElement: ".contact-form-animation"})
			.setVelocity(".crew", {opacity: 1, left: "77%", scale: "1"}, 1000)
			.triggerHook(0.1)
			.addTo(controller);
	};

	CRUMINA.perfectScrollbarInit = function () {
		var $chatContainer = $('.popup-chat-responsive .mCustomScrollbar');
		var $containers = $('.mCustomScrollbar');

		$containers.perfectScrollbar({wheelPropagation:false});

		if(!$chatContainer.length){
			return;
		}

		$chatContainer.scrollTop( $chatContainer.prop( "scrollHeight" ) );
		$chatContainer.perfectScrollbar('update');
	};


	/* -----------------------------
 * Responsive
 * ---------------------------*/
	CRUMINA.responsive = {
		$profilePanel: null,
		$desktopContainerPanel: null,
		$responsiveContainerPanel: null,
		init: function () {
			this.$profilePanel = jQuery('#profile-panel');
			this.$desktopContainerPanel = jQuery('#desktop-container-panel > .ui-block');
			this.$responsiveContainerPanel = jQuery('#responsive-container-panel .ui-block');
			this.update();
		},
		mixPanel: function () {
			if (window.matchMedia("(max-width: 1024px)").matches) {
				this.$responsiveContainerPanel.append(this.$profilePanel);

			} else {
				this.$desktopContainerPanel.append(this.$profilePanel);
			}
		},
		update: function () {
			var _this = this;
			var resizeTimer = null;
			var resize = function () {
				resizeTimer = null;

				// Methods
				_this.mixPanel();
			};

			$(window).on('resize', function () {
				if (resizeTimer === null) {
					resizeTimer = window.setTimeout(function () {
						resize();
					}, 300);
				}
			}).resize();
		}
	};

	/* -----------------------------
	 * On DOM ready functions
	 * ---------------------------*/

	$document.ready(function () {

		CRUMINA.preloader();

		CRUMINA.perfectScrollbarInit();

		// Row background animation
		if ($('.call-to-action-animation').length) {
			CRUMINA.CallToActionAnimation();
		}

		if ($('.img-scale-animation').length) {
			CRUMINA.ImgScaleAnimation()
		}

		if ($('.subscribe-animation').length) {
			CRUMINA.SubscribeAnimation()
		}

		if ($('.planer-animation').length) {
			CRUMINA.PlanerAnimation()
		}

		if ($('.contact-form-animation').length) {
			CRUMINA.ContactAnimationAnimation()
		}

        // Run scripts only if they included on page.

        if (typeof $.fn.gifplayer !== 'undefined'){
            $('.gif-play-image').gifplayer();
        }
        if (typeof $.fn.mediaelementplayer !== 'undefined'){
            $('#mediaplayer').mediaelementplayer({
                "features": ['prevtrack', 'playpause', 'nexttrack', 'loop', 'shuffle', 'current', 'progress', 'duration', 'volume']
            });
        }

		CRUMINA.responsive.init();

	});
})(jQuery);

// 头像裁剪
window.onload = function () {
	'use strict';

	var Cropper = window.Cropper;
	var URL = window.URL || window.webkitURL;
	var container = document.querySelector('.img-container');
	var image = container.getElementsByTagName('img').item(0);
	var download = document.getElementById('download');
	var actions = document.getElementById('actions');
	var dataX = document.getElementById('dataX');
	var dataY = document.getElementById('dataY');
	var dataHeight = document.getElementById('dataHeight');
	var dataWidth = document.getElementById('dataWidth');
	var dataRotate = document.getElementById('dataRotate');
	var dataScaleX = document.getElementById('dataScaleX');
	var dataScaleY = document.getElementById('dataScaleY');
	var options = {
		aspectRatio: 16 / 9,
		preview: '.img-preview',
		ready: function (e) {
			console.log(e.type);
		},
		cropstart: function (e) {
			console.log(e.type, e.detail.action);
		},
		cropmove: function (e) {
			console.log(e.type, e.detail.action);
		},
		cropend: function (e) {
			console.log(e.type, e.detail.action);
		},
		crop: function (e) {
			var data = e.detail;

			console.log(e.type);
			dataX.value = Math.round(data.x);
			dataY.value = Math.round(data.y);
			dataHeight.value = Math.round(data.height);
			dataWidth.value = Math.round(data.width);
			dataRotate.value = typeof data.rotate !== 'undefined' ? data.rotate : '';
			dataScaleX.value = typeof data.scaleX !== 'undefined' ? data.scaleX : '';
			dataScaleY.value = typeof data.scaleY !== 'undefined' ? data.scaleY : '';
		},
		zoom: function (e) {
			console.log(e.type, e.detail.ratio);
		}
	};
	var cropper = new Cropper(image, options);
	var originalImageURL = image.src;
	var uploadedImageType = 'image/jpeg';
	var uploadedImageName = 'cropped.jpg';
	var uploadedImageURL;

	// Tooltip
	$('[data-toggle="tooltip"]').tooltip();

	// Buttons
	if (!document.createElement('canvas').getContext) {
		$('button[data-method="getCroppedCanvas"]').prop('disabled', true);
	}

	if (typeof document.createElement('cropper').style.transition === 'undefined') {
		$('button[data-method="rotate"]').prop('disabled', true);
		$('button[data-method="scale"]').prop('disabled', true);
	}

	// Download
	if (typeof download.download === 'undefined') {
		download.className += ' disabled';
		download.title = 'Your browser does not support download';
	}

	// Options
	actions.querySelector('.docs-toggles').onchange = function (event) {
		var e = event || window.event;
		var target = e.target || e.srcElement;
		var cropBoxData;
		var canvasData;
		var isCheckbox;
		var isRadio;

		if (!cropper) {
			return;
		}

		if (target.tagName.toLowerCase() === 'label') {
			target = target.querySelector('input');
		}

		isCheckbox = target.type === 'checkbox';
		isRadio = target.type === 'radio';

		if (isCheckbox || isRadio) {
			if (isCheckbox) {
				options[target.name] = target.checked;
				cropBoxData = cropper.getCropBoxData();
				canvasData = cropper.getCanvasData();

				options.ready = function () {
					console.log('ready');
					cropper.setCropBoxData(cropBoxData).setCanvasData(canvasData);
				};
			} else {
				options[target.name] = target.value;
				options.ready = function () {
					console.log('ready');
				};
			}

			// Restart
			cropper.destroy();
			cropper = new Cropper(image, options);
		}
	};

	// Methods
	actions.querySelector('.docs-buttons').onclick = function (event) {
		var e = event || window.event;
		var target = e.target || e.srcElement;
		var cropped;
		var result;
		var input;
		var data;

		if (!cropper) {
			return;
		}

		while (target !== this) {
			if (target.getAttribute('data-method')) {
				break;
			}

			target = target.parentNode;
		}

		if (target === this || target.disabled || target.className.indexOf('disabled') > -1) {
			return;
		}

		data = {
			method: target.getAttribute('data-method'),
			target: target.getAttribute('data-target'),
			option: target.getAttribute('data-option') || undefined,
			secondOption: target.getAttribute('data-second-option') || undefined
		};

		cropped = cropper.cropped;

		if (data.method) {
			if (typeof data.target !== 'undefined') {
				input = document.querySelector(data.target);

				if (!target.hasAttribute('data-option') && data.target && input) {
					try {
						data.option = JSON.parse(input.value);
					} catch (e) {
						console.log(e.message);
					}
				}
			}

			switch (data.method) {
				case 'rotate':
					if (cropped && options.viewMode > 0) {
						cropper.clear();
					}

					break;

				case 'getCroppedCanvas':
					try {
						data.option = JSON.parse(data.option);
					} catch (e) {
						console.log(e.message);
					}

					if (uploadedImageType === 'image/jpeg') {
						if (!data.option) {
							data.option = {};
						}

						data.option.fillColor = '#fff';
					}

					break;
			}

			result = cropper[data.method](data.option, data.secondOption);

			switch (data.method) {
				case 'rotate':
					if (cropped && options.viewMode > 0) {
						cropper.crop();
					}

					break;

				case 'scaleX':
				case 'scaleY':
					target.setAttribute('data-option', -data.option);
					break;

				case 'getCroppedCanvas':
					if (result) {
						// Bootstrap's Modal
						$('#getCroppedCanvasModal').modal().find('.modal-body').html(result);

						if (!download.disabled) {
							download.download = uploadedImageName;
							download.href = result.toDataURL(uploadedImageType);
						}
					}

					break;

				case 'destroy':
					cropper = null;

					if (uploadedImageURL) {
						URL.revokeObjectURL(uploadedImageURL);
						uploadedImageURL = '';
						image.src = originalImageURL;
					}

					break;
			}

			if (typeof result === 'object' && result !== cropper && input) {
				try {
					input.value = JSON.stringify(result);
				} catch (e) {
					console.log(e.message);
				}
			}
		}
	};

	document.body.onkeydown = function (event) {
		var e = event || window.event;

		if (e.target !== this || !cropper || this.scrollTop > 300) {
			return;
		}

		switch (e.keyCode) {
			case 37:
				e.preventDefault();
				cropper.move(-1, 0);
				break;

			case 38:
				e.preventDefault();
				cropper.move(0, -1);
				break;

			case 39:
				e.preventDefault();
				cropper.move(1, 0);
				break;

			case 40:
				e.preventDefault();
				cropper.move(0, 1);
				break;
		}
	};

	// Import image
	var inputImage = document.getElementById('inputImage');

	if (URL) {
		inputImage.onchange = function () {
			var files = this.files;
			var file;

			if (cropper && files && files.length) {
				file = files[0];

				if (/^image\/\w+/.test(file.type)) {
					uploadedImageType = file.type;
					uploadedImageName = file.name;

					if (uploadedImageURL) {
						URL.revokeObjectURL(uploadedImageURL);
					}

					image.src = uploadedImageURL = URL.createObjectURL(file);
					cropper.destroy();
					cropper = new Cropper(image, options);
					inputImage.value = null;
				} else {
					window.alert('Please choose an image file.');
				}
			}
		};
	} else {
		inputImage.disabled = true;
		inputImage.parentNode.className += ' disabled';
	}
};
