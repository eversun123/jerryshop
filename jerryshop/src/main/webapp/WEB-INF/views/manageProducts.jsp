<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- Form elements -->
					<form class="form-horizontal">
						<!------------------------------------------------ name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<input type="text" name="name" id="name"
									placeholder="Product Name" class="form-control" /> <em
									class="help-block">Please enter Product Name</em>
							</div>
						</div>
						<!------------------------------------------------Brand  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Brand:</label>
							<div class="col-md-8">
								<input type="text" name="brand" id="brand"
									placeholder="Product Brand" class="form-control" /> <em
									class="help-block">Please enter Product Brand</em>
							</div>
						</div>
						<!------------------------------------------------Description  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Description:</label>
							<div class="col-md-8">
								<textarea name="description" id="description" rows="4"
									placeholder="Write a description">
								</textarea>
							</div>
						</div>
						<!------------------------------------------------Unit Price  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Unit
								Price</label>
							<div class="col-md-8">
								<input type="number" name="unitPrice" id="unitPrice"
									placeholder="Enter Unit Price" class="form-control" />
							</div>
						</div>
						<!------------------------------------------------Quantity -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Quantity Available:</label>
							<div class="col-md-8">
								<input type="number" name="quantity" id="quantity"
									placeholder="quantity available" class="form-control" />
							</div>
						</div>
						<!------------------------------------------------Category -->
						<div class="form-group">
							<label class="control-label col-md-4" for="catagoryId">Select
								Category:</label>
							<div class="col-md-8">
								<select name="catagoryId" id="catagoryId" class="form-control">
									<option value="1">Category One</option>
									<option value="2">Category Two</option>
								</select>
							</div>
						</div>
						<!------------------------------------------------Submit  -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8 ">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
