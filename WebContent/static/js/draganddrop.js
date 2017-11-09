  $( function() {
	 //chargerBase();
    // There's the gallery and the trash
    var $gallery = $( "#gallery" ),
      $trash = $( "#trash" );
 
    // Let the gallery items be draggable
    $( "li", $gallery ).draggable({
      cancel: "a.ui-icon", // clicking an icon won't initiate dragging
      revert: "invalid", // when not dropped, the item will revert back to its initial position
      containment: "document",
      helper: "clone",
      cursor: "move"
    });
 
    // Let the trash be droppable, accepting the gallery items
    $trash.droppable({
      accept: "#gallery > li",
      classes: {
        "ui-droppable-active": "ui-state-highlight"
      },
      drop: function( event, ui ) {
        deleteImage( ui.draggable );
      }
    });
 
    // Let the gallery be droppable as well, accepting items from the trash
    $gallery.droppable({
      accept: "#trash li",
      classes: {
        "ui-droppable-active": "custom-state-active"
      },
      drop: function( event, ui ) {
        recycleImage( ui.draggable );
      }
    });
 
    // Image deletion function
    var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='Retirer de la salle' class='ui-icon ui-icon-refresh'>Retirer la machine</a>";
    function deleteImage( $item ) {
      $item.fadeOut(function() {
        var $list = $( "ul", $trash ).length ?
          $( "ul", $trash ) :
          $( "<ul id='salleList' class='gallery ui-helper-reset'/>" ).appendTo( $trash );
 
        $item.find( "a.ui-icon-plus" ).remove();
        $item.append( recycle_icon ).appendTo( $list ).fadeIn(function() {
          $item
            .animate({ width: "65px" })
            .find( "img" )
              .animate({ height: "36px" });
        });
      });
    }
 
    // Image recycle function
    var trash_icon = "<a href='link/to/trash/script/when/we/have/js/off' title='Ajouter cette machine' class='ui-icon ui-icon-plus'>Ajouter poste</a>";
    function recycleImage( $item ) {
      $item.fadeOut(function() {
        $item
          .find( "a.ui-icon-refresh" )
            .remove()
          .end()
          .css( "width", "96px")
          .append( trash_icon )
          .find( "img" )
            .css( "height", "72px" )
          .end()
          .appendTo( $gallery )
          .fadeIn();
      });
    }
 
    // Image preview function, demonstrating the ui.dialog used as a modal window
    function viewLargerImage( $link ) {
      var src = $link.attr( "href" ),
        title = $link.siblings( "img" ).attr( "alt" ),
        $modal = $( "img[src$='" + src + "']" );
 
      if ( $modal.length ) {
        $modal.dialog( "open" );
      } else {
        var img = $( "<img alt='" + title + "' width='384' height='288' style='display: none; padding: 8px;' />" )
          .attr( "src", src ).appendTo( "body" );
        setTimeout(function() {
          img.dialog({
            title: title,
            width: 400,
            modal: true
          });
        }, 1 );
      }
    }
 
    // Resolve the icons behavior with event delegation
    $( "ul.gallery > li" ).on( "click", function( event ) {
      var $item = $( this ),
        $target = $( event.target );
 
      if ( $target.is( "a.ui-icon-plus" ) ) {
        deleteImage( $item );
      } else if ( $target.is( "a.ui-icon-zoomin" ) ) {
        viewLargerImage( $target );
      } else if ( $target.is( "a.ui-icon-refresh" ) ) {
        recycleImage( $item );
      }
 
      return false;
    });
  } );
  function chargerBase(){
	  var e = document.getElementById('nomSalle');
	  var value = e.options[e.selectedIndex].id;
	  
		$.ajax({
			type : "GET",
			url : "http://localhost:8080/MonitoringToolsBO/getMachinesBySalle",          // refer to corresponding Service 
			data: "idSalle="+ value,
			success : function(data) {
				$(salleList).empty();
				for(var i=0; i<data.length; i++){
				$('#divSalle ul').append($('<li class="ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle" id="'+data[i].idMachine+'" style="width: 65px;">')
					    .append($('<h5 class="ui-widget-header">"'+data[i].idMachine+'"</h5>'))
					    .append($(' <img src="" alt="'+data[i].urlMachine+'" style="display: inline-block; height: 36px;" height="72" width="96">'))
					    .append($(' <a href="" title="Détail" class="ui-icon ui-icon-zoomin">Détail</a>'))
					    .append($('  <a onclick="sortirSalle('+data[i].idMachine+');" title="Retirer de la salle" class="ui-icon ui-icon-refresh">Retirer la machine</a>')))
				}
			},
			error : function() {
				alert("Failed to load Country details");
			}
		});
  }
  function sortirSalle(idMachine){
	  
	  var value = 1;
		formData = {
				idMachine : idMachine,
				idSalle : value,
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/MonitoringToolsBO/updateSalle2",   // refer to corresponding Service 
			data: JSON.stringify(formData),
		    contentType : "application/json",
			success : function(response) {
				$('#listSalleout ul').append($('<li class="ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle" id="'+response.idMachine+'" style="width: 65px;">')
					    .append($('<h5 class="ui-widget-header">"'+response.idMachine+'"</h5>'))
					    .append($(' <img src="" alt="'+response.urlMachine+'"height="72" width="96">'))
					    .append($(' <a href="" title="Détail" class="ui-icon ui-icon-zoomin">Détail</a>'))
					    .append($(' <a href="link/to/trash/script/when/we/have/js/off" title="Ajouter à la salle" class="ui-icon ui-icon-plus">Ajouter</a>')))
				location.reload();
			},
			error : function() {
				alert("Failed to update Salle");
			}
		});	
	
	  
  }
  function enregistrerSalle(){

	  var list = document.getElementById('salleList').getElementsByTagName('li');
	  var elements = [];
	  for(var i=0; i<list.length;i++){
		  elements.push(list[i].id);

	  }

	  
	  var e = document.getElementById('nomSalle');
	  var value = e.options[e.selectedIndex].id;
	  


		var formData;
		
		formData = {
				idMachine : elements,
				idSalle : value,
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/MonitoringToolsBO/updateSalle",   // refer to corresponding Service 
			data: JSON.stringify(formData),
		    contentType : "application/json",
			success : function(response) {
				alert("Sucess !");
				location.reload();
			},
			error : function() {
				alert("Failed to update Salle");
			}
		});	
	  
  }