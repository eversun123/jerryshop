
<%@include file="../shared/flows-header.jsp"%>
<!-- Page Content -->
<div class="container">
	<div class="row">

		<!-- column to display the personal details -->
		<div class="col-sm-6">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
				<div class="panel-body">
					<!-- code to display the personal details -->
					<a href="${flowExecutionUrl}&_eventId_personal"
						class="btn btn-primary">Edit</a>
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of personal details -->

				</div>
			</div>

		</div>

		<!-- column to display the address  -->
		<div class="col-sm-6">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
				<div class="panel-body">
					<!-- code to display the communication address -->
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of address -->
					<a href="${flowExecutionUrl}&_eventId_billing"
						class="btn btn-primary">Edit</a>
				</div>
			</div>

		</div>

	</div>

	<!-- to provide the confirm button after displaying the details -->
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">

			<div class="text-center">

				<a href="${flowExecutionUrl}&_eventId_success"
					class="btn btn-primary">Conform</a>

			</div>

		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>