(function($) {
	$.fn.extend({
		lSelect: function(options) {
			var settings = {
				choose: "请选择...",
				emptyValue: "",
				cssStyle: {"margin-right": "4px"},
				url: null,
				type: "GET"
			};
			$.extend(settings, options);

			var cache = {};
			return this.each(function() {
				var lSelectId = new Date().getTime();
				var $input = $(this);
				var treePath = $input.attr("treePath");

				if (treePath != null && treePath != "") { //,2579,2670,233,
					var ids = (treePath + $input.val() + ",").split(",");
					var $position = $input;
					for (var i = 1; i < ids.length; i ++) {
						$position = addSelect($position, ids[i - 1], ids[i]);
					}
				} else {
					addSelect($input, null, null);
				}

				function addSelect($position, parentId, currentId) {
					$position.nextAll("select[name=" + lSelectId + "]").remove();
					if ($position.is("select") && (parentId == null || parentId == "")) {
						return false;
					}
					if (cache[parentId] == null) {
						$.ajax({
							url: settings.url,
							type: settings.type,
							data: parentId != null ? {parentId: parentId} : null,
							dataType: "json",
							cache: false,
							async: false, // 是否异步：true=异步， false=同步
							success: function(data) {
								if (data.resultCode == 1) {
                                    cache[parentId] = data.result;
								}
							}
						});
					}
					var data = cache[parentId];
					if ($.isEmptyObject(data)) {
						return false;
					}
					var select = '<select name="' + lSelectId + '">';
					if (settings.emptyValue != null && settings.choose != null) {
						select += '<option value="' + settings.emptyValue + '">' + settings.choose + '</option>';
					}
					// for (var i =0; i < data.length; i++) {
					// 	var option = data[i];
                     //    if(option.value == currentId) {
                     //        select += '<option value="' + option.value + '" selected="selected">' + option.name + '</option>';
                     //    } else {
                     //        select += '<option value="' + option.value + '">' + option.name + '</option>';
                     //    }
					// }

					$.each(data, function(i, option) {
						if(option.id == currentId) {
							select += '<option value="' + option.id + '" selected="selected">' + option.name + '</option>';
						} else {
							select += '<option value="' + option.id + '">' + option.name + '</option>';
						}
					});
					select += '</select>';
					return $(select).css(settings.cssStyle).insertAfter($position).on("change", function() {
						var $this = $(this);
						if ($this.val() == "") {
							var $prev = $this.prev("select[name=" + lSelectId + "]");
							if ($prev.size() > 0) {
								$input.val($prev.val());
							} else {
								$input.val(settings.emptyValue);
							}
						} else {
							$input.val($this.val());
						}
						addSelect($this, $this.val(), null);
					});
				}
			});

		}
	});
})(jQuery)